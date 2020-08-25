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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class g extends BaseAdapter {
    private BdUniqueId ahK;
    private TbPageContext<BaseFragmentActivity> hHG;
    private String lkJ;
    private PersonPostModel llT;
    private PersonPostModel.a lwA;
    private final PersonPostModel.a lwB = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.llT = personPostModel;
                Iterator<q> it = g.this.llT.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.llT != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.llT.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.lwA != null) {
                g.this.lwA.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0783a lwC = new a.InterfaceC0783a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0783a
        public void dg(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.hHG.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.hHG.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.hHG.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.hHG.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.hHG = tbPageContext;
        this.mUid = str;
        this.ahK = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.lwA = aVar;
    }

    public void vg(boolean z) {
        if (this.llT == null) {
            this.llT = new PersonPostModel(this.hHG, this.ahK, null, true, PersonPostModel.FROM_PERSON_POST);
            this.llT.setUniqueId(this.ahK);
        }
        this.llT.fetchPost(this.hHG, this.lwB, z, this.mUid, false, true, false, null);
    }

    public void coU() {
        if (this.llT != null) {
            this.llT.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.llT == null || this.llT.postList == null) {
            return 0;
        }
        return this.llT.postList.size();
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
            aVar = new a(view, this.hHG);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.lnX.setVisibility(0);
        } else {
            aVar.lnX.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList FM(int i) {
        return (PersonPostModel.PostInfoList) this.llT.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList FM = FM(i);
        if (this.lkJ == null) {
            this.lkJ = FM.user_portrait;
        }
        aVar.a(FM, false, this.lkJ);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = FM.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (FM.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!FM.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = FM.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(FM.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(FM.thread_id), String.valueOf(FM.content[i2].post_id), String.valueOf(FM.content[i2].post_type), at.getFormatTime(FM.content[i2].create_time * 1000), String.valueOf(FM.thread_type)});
            }
        }
        aVar.lwE.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(FM.title).find()) {
            aVar.lnQ.setText(FM.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.lnQ.setText(FM.title);
        }
        if (FM.originalThreadInfo != null && !StringUtils.isNull(FM.originalThreadInfo.showText)) {
            aVar.lnQ.setText("分享：" + FM.originalThreadInfo.showText);
        }
        aVar.lnQ.setTag(new String[]{String.valueOf(FM.thread_id), null, null, String.valueOf(FM.thread_type)});
        if (FM.thread_type == 33) {
            aVar.lnQ.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.lnQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.lnQ, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.lnQ, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.lnQ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.lwC);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes18.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View hkf;
        private View hkg;
        public TextView lnQ;
        public ReplyLinearLayout lwE;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.lwE = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.lnQ = (TextView) view.findViewById(R.id.original_post_title);
            this.hkf = view.findViewById(R.id.reply_top_line);
            this.hkg = view.findViewById(R.id.reply_bottom_line);
            this.lnQ.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.lnQ, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.lnQ, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hkf, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hkg, R.color.cp_bg_line_c);
        }
    }
}
