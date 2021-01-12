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
/* loaded from: classes7.dex */
public class g extends BaseAdapter {
    private BdUniqueId agN;
    private TbPageContext<BaseFragmentActivity> iPu;
    private PersonPostModel.a mCu;
    private final PersonPostModel.a mCw = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.mrQ = personPostModel;
                Iterator<n> it = g.this.mrQ.postList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.mrQ != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.mrQ.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mCu != null) {
                g.this.mCu.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0846a mCx = new a.InterfaceC0846a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0846a
        public void ea(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iPu.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iPu.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iPu.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iPu.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;
    private String mqF;
    private PersonPostModel mrQ;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iPu = tbPageContext;
        this.mUid = str;
        this.agN = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mCu = aVar;
    }

    public void xb(boolean z) {
        if (this.mrQ == null) {
            this.mrQ = new PersonPostModel(this.iPu, this.agN, null, true, PersonPostModel.FROM_PERSON_POST);
            this.mrQ.setUniqueId(this.agN);
        }
        this.mrQ.fetchPost(this.iPu, this.mCw, z, this.mUid, false, true, false, null);
    }

    public void cEk() {
        if (this.mrQ != null) {
            this.mrQ.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mrQ == null || this.mrQ.postList == null) {
            return 0;
        }
        return this.mrQ.postList.size();
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
            aVar = new a(view, this.iPu);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.mtY.setVisibility(0);
        } else {
            aVar.mtY.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Hb(int i) {
        return (PersonPostModel.PostInfoList) this.mrQ.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Hb = Hb(i);
        if (this.mqF == null) {
            this.mqF = Hb.user_portrait;
        }
        aVar.a(Hb, false, this.mqF);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Hb.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Hb.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Hb.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Hb.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Hb.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Hb.thread_id), String.valueOf(Hb.content[i2].post_id), String.valueOf(Hb.content[i2].post_type), at.getFormatTime(Hb.content[i2].create_time * 1000), String.valueOf(Hb.thread_type)});
            }
        }
        aVar.mCz.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Hb.title).find()) {
            aVar.mtR.setText(Hb.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.mtR.setText(Hb.title);
        }
        if (Hb.originalThreadInfo != null && !StringUtils.isNull(Hb.originalThreadInfo.showText)) {
            aVar.mtR.setText("分享：" + Hb.originalThreadInfo.showText);
        }
        aVar.mtR.setTag(new String[]{String.valueOf(Hb.thread_id), null, null, String.valueOf(Hb.thread_type)});
        if (Hb.thread_type == 33) {
            aVar.mtR.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.mtR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ao.setBackgroundResource(aVar.mtR, R.drawable.person_post_line);
        ao.setViewTextColor(aVar.mtR, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.mtR.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mCx);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes7.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View irN;
        private View irO;
        public ReplyLinearLayout mCz;
        public TextView mtR;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mCz = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.mtR = (TextView) view.findViewById(R.id.original_post_title);
            this.irN = view.findViewById(R.id.reply_top_line);
            this.irO = view.findViewById(R.id.reply_bottom_line);
            this.mtR.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ao.setBackgroundResource(this.mtR, R.color.CAM_X0205);
            ao.setViewTextColor(this.mtR, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(this.irN, R.color.CAM_X0204);
            ao.setBackgroundResource(this.irO, R.color.CAM_X0204);
        }
    }
}
