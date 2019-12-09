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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class g extends BaseAdapter {
    private BdUniqueId GX;
    private TbPageContext<BaseFragmentActivity> fjz;
    private PersonPostModel.a iBn;
    private final PersonPostModel.a iBo = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.iqV = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.iqV.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.iqV != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.iqV.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.iBn != null) {
                g.this.iBn.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0494a iBp = new a.InterfaceC0494a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0494a
        public void cK(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.fjz.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.fjz.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.fjz.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.fjz.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private String ipT;
    private PersonPostModel iqV;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.fjz = tbPageContext;
        this.mUid = str;
        this.GX = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.iBn = aVar;
    }

    public void pU(boolean z) {
        if (this.iqV == null) {
            this.iqV = new PersonPostModel(this.fjz, this.GX, null, true, PersonPostModel.FROM_PERSON_POST);
            this.iqV.setUniqueId(this.GX);
        }
        this.iqV.fetchPost(this.fjz, this.iBo, z, this.mUid, false, true, false);
    }

    public void bmt() {
        if (this.iqV != null) {
            this.iqV.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iqV == null || this.iqV.postList == null) {
            return 0;
        }
        return this.iqV.postList.size();
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
            aVar = new a(view, this.fjz);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.isg.setVisibility(0);
        } else {
            aVar.isg.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList xO(int i) {
        return (PersonPostModel.PostInfoList) this.iqV.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList xO = xO(i);
        if (this.ipT == null) {
            this.ipT = xO.user_portrait;
        }
        aVar.a(xO, false, this.ipT);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = xO.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (xO.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!xO.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = xO.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(xO.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(xO.thread_id), String.valueOf(xO.content[i2].post_id), String.valueOf(xO.content[i2].post_type), aq.getFormatTime(xO.content[i2].create_time * 1000), String.valueOf(xO.thread_type)});
            }
        }
        aVar.iBr.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(xO.title).find()) {
            aVar.irZ.setText(xO.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.irZ.setText(xO.title);
        }
        if (xO.originalThreadInfo != null && !StringUtils.isNull(xO.originalThreadInfo.showText)) {
            aVar.irZ.setText("分享：" + xO.originalThreadInfo.showText);
        }
        aVar.irZ.setTag(new String[]{String.valueOf(xO.thread_id), null, null, String.valueOf(xO.thread_type)});
        if (xO.thread_type == 33) {
            aVar.irZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.irZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.irZ, R.drawable.person_post_line);
        am.setViewTextColor(aVar.irZ, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.irZ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.iBp);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View eMM;
        private View eMN;
        public ReplyLinearLayout iBr;
        public TextView irZ;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.iBr = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.irZ = (TextView) view.findViewById(R.id.original_post_title);
            this.eMM = view.findViewById(R.id.reply_top_line);
            this.eMN = view.findViewById(R.id.reply_bottom_line);
            this.irZ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.irZ, R.color.cp_bg_line_e);
            am.setViewTextColor(this.irZ, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.eMM, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eMN, R.color.cp_bg_line_c);
        }
    }
}
