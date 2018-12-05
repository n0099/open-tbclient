package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gyA;
    private static String gyB;
    public TextView aIX;
    public TextView aJK;
    public TextView aKp;
    public HeadImageView eaP;
    private final LinearLayout fHp;
    private InterfaceC0299a gFV;
    private int gyC;
    public LinearLayout gyD;
    public TextView gyE;
    protected final LinearLayout gyx;
    protected final ColumnLayout gyy;
    protected final ColumnLayout gyz;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0299a {
        void bL(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gyD = (LinearLayout) view.findViewById(e.g.top_line);
        this.eaP = (HeadImageView) view.findViewById(e.g.portrait);
        this.aKp = (TextView) view.findViewById(e.g.username);
        this.aIX = (TextView) view.findViewById(e.g.reply_time);
        this.aJK = (TextView) view.findViewById(e.g.forum_name);
        this.gyE = (TextView) view.findViewById(e.g.reply_count);
        this.fHp = (LinearLayout) view.findViewById(e.g.item_content);
        this.gyy = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gyz = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.gyx = (LinearLayout) view.findViewById(e.g.person_child);
        this.gyC = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fHp != null) {
            this.fHp.setOnClickListener(this);
        }
        this.eaP.setOnClickListener(this);
        this.aKp.setOnClickListener(this);
        this.aJK.setOnClickListener(this);
        this.gyE.setOnClickListener(this);
        this.gyy.setOnClickListener(this);
        this.gyz.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gFV != null) {
            this.gFV.bL(view);
        }
    }

    public void a(InterfaceC0299a interfaceC0299a) {
        this.gFV = interfaceC0299a;
    }

    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        boolean z2;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String[] strArr = new String[4];
        try {
            if (z) {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.post_id);
                str3 = ao.L(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
                strArr[3] = String.valueOf(postInfoList.thread_type);
            } else {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                strArr[3] = String.valueOf(postInfoList.thread_type);
                str3 = ao.L(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aKp.setText(str2);
            this.aIX.setText(str3);
            this.aJK.setText(str4);
            this.aJK.setTag(str4);
            this.gyE.setText(str5);
            this.aJK.setOnClickListener(this);
            tO(str);
            if (this.fHp != null) {
                this.fHp.setTag(strArr);
            }
            this.gyy.setTag(strArr);
            this.gyz.setTag(strArr);
        }
    }

    private void tO(String str) {
        if (gyB != null && !gyB.equals(str)) {
            gyA = null;
        }
        if (gyA != null) {
            this.eaP.setImageBitmap(gyA.op());
            gyB = str;
            return;
        }
        this.eaP.startLoad(str, 12, this.gyC, this.gyC, false);
    }

    public void ey(int i) {
        al.c(this.aJK, e.d.cp_cont_d, 1);
        al.c(this.aIX, e.d.cp_cont_d, 1);
        al.c(this.aKp, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.gyx, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.gyE.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.gyE, e.d.cp_link_tip_c, 1);
    }
}
