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
    private BdUniqueId Hx;
    private TbPageContext<BaseFragmentActivity> fkq;
    private PersonPostModel.a iCe;
    private final PersonPostModel.a iCf = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.irM = personPostModel;
                Iterator<com.baidu.adp.widget.ListView.m> it = g.this.irM.postList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.m next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.irM != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.irM.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.iCe != null) {
                g.this.iCe.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0499a iCg = new a.InterfaceC0499a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0499a
        public void cK(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.fkq.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.fkq.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.fkq.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.fkq.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private String iqK;
    private PersonPostModel irM;
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.fkq = tbPageContext;
        this.mUid = str;
        this.Hx = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.iCe = aVar;
    }

    public void pU(boolean z) {
        if (this.irM == null) {
            this.irM = new PersonPostModel(this.fkq, this.Hx, null, true, PersonPostModel.FROM_PERSON_POST);
            this.irM.setUniqueId(this.Hx);
        }
        this.irM.fetchPost(this.fkq, this.iCf, z, this.mUid, false, true, false);
    }

    public void bmv() {
        if (this.irM != null) {
            this.irM.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.irM == null || this.irM.postList == null) {
            return 0;
        }
        return this.irM.postList.size();
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
            aVar = new a(view, this.fkq);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.isX.setVisibility(0);
        } else {
            aVar.isX.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList xP(int i) {
        return (PersonPostModel.PostInfoList) this.irM.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList xP = xP(i);
        if (this.iqK == null) {
            this.iqK = xP.user_portrait;
        }
        aVar.a(xP, false, this.iqK);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = xP.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (xP.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!xP.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = xP.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(xP.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(xP.thread_id), String.valueOf(xP.content[i2].post_id), String.valueOf(xP.content[i2].post_type), aq.getFormatTime(xP.content[i2].create_time * 1000), String.valueOf(xP.thread_type)});
            }
        }
        aVar.iCi.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(xP.title).find()) {
            aVar.isQ.setText(xP.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.isQ.setText(xP.title);
        }
        if (xP.originalThreadInfo != null && !StringUtils.isNull(xP.originalThreadInfo.showText)) {
            aVar.isQ.setText("分享：" + xP.originalThreadInfo.showText);
        }
        aVar.isQ.setTag(new String[]{String.valueOf(xP.thread_id), null, null, String.valueOf(xP.thread_type)});
        if (xP.thread_type == 33) {
            aVar.isQ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.isQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        am.setBackgroundResource(aVar.isQ, R.drawable.person_post_line);
        am.setViewTextColor(aVar.isQ, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.isQ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.iCg);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes6.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View eND;
        private View eNE;
        public ReplyLinearLayout iCi;
        public TextView isQ;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.iCi = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.isQ = (TextView) view.findViewById(R.id.original_post_title);
            this.eND = view.findViewById(R.id.reply_top_line);
            this.eNE = view.findViewById(R.id.reply_bottom_line);
            this.isQ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            am.setBackgroundResource(this.isQ, R.color.cp_bg_line_e);
            am.setViewTextColor(this.isQ, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.eND, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.eNE, R.color.cp_bg_line_c);
        }
    }
}
