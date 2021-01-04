package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private BdUniqueId ahE;
    private TbPageContext<BaseFragmentActivity> iUb;
    private PersonPostModel.a mHe;
    private final PersonPostModel.a mHf = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.mww = personPostModel;
                Iterator<n> it = g.this.mww.postList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.mww != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.mww.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mHe != null) {
                g.this.mHe.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0830a mHg = new a.InterfaceC0830a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0830a
        public void ea(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iUb.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iUb.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iUb.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iUb.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;
    private String mvl;
    private PersonPostModel mww;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iUb = tbPageContext;
        this.mUid = str;
        this.ahE = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mHe = aVar;
    }

    public void xf(boolean z) {
        if (this.mww == null) {
            this.mww = new PersonPostModel(this.iUb, this.ahE, null, true, PersonPostModel.FROM_PERSON_POST);
            this.mww.setUniqueId(this.ahE);
        }
        this.mww.fetchPost(this.iUb, this.mHf, z, this.mUid, false, true, false, null);
    }

    public void cIb() {
        if (this.mww != null) {
            this.mww.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mww == null || this.mww.postList == null) {
            return 0;
        }
        return this.mww.postList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.iUb);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.myD.setVisibility(0);
        } else {
            aVar.myD.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList II(int i) {
        return (PersonPostModel.PostInfoList) this.mww.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList II = II(i);
        if (this.mvl == null) {
            this.mvl = II.user_portrait;
        }
        aVar.a(II, false, this.mvl);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = II.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (II.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!II.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = II.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(II.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(II.thread_id), String.valueOf(II.content[i2].post_id), String.valueOf(II.content[i2].post_type), at.getFormatTime(II.content[i2].create_time * 1000), String.valueOf(II.thread_type)});
            }
        }
        aVar.mHi.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(II.title).find()) {
            aVar.myw.setText(II.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.myw.setText(II.title);
        }
        if (II.originalThreadInfo != null && !StringUtils.isNull(II.originalThreadInfo.showText)) {
            aVar.myw.setText("分享：" + II.originalThreadInfo.showText);
        }
        aVar.myw.setTag(new String[]{String.valueOf(II.thread_id), null, null, String.valueOf(II.thread_type)});
        if (II.thread_type == 33) {
            aVar.myw.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.myw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ao.setBackgroundResource(aVar.myw, R.drawable.person_post_line);
        ao.setViewTextColor(aVar.myw, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.myw.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mHg);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes8.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View iwu;
        private View iwv;
        public ReplyLinearLayout mHi;
        public TextView myw;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mHi = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.myw = (TextView) view.findViewById(R.id.original_post_title);
            this.iwu = view.findViewById(R.id.reply_top_line);
            this.iwv = view.findViewById(R.id.reply_bottom_line);
            this.myw.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ao.setBackgroundResource(this.myw, R.color.CAM_X0205);
            ao.setViewTextColor(this.myw, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(this.iwu, R.color.CAM_X0204);
            ao.setBackgroundResource(this.iwv, R.color.CAM_X0204);
        }
    }
}
