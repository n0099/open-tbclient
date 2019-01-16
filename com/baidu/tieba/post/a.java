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
    private static com.baidu.adp.widget.ImageView.a gCv;
    private static String gCw;
    public TextView aJA;
    public TextView aKT;
    public TextView aKo;
    public HeadImageView eem;
    private final LinearLayout fLb;
    protected final LinearLayout gCs;
    protected final ColumnLayout gCt;
    protected final ColumnLayout gCu;
    private int gCx;
    public LinearLayout gCy;
    public TextView gCz;
    private InterfaceC0299a gJQ;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0299a {
        void bO(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gCy = (LinearLayout) view.findViewById(e.g.top_line);
        this.eem = (HeadImageView) view.findViewById(e.g.portrait);
        this.aKT = (TextView) view.findViewById(e.g.username);
        this.aJA = (TextView) view.findViewById(e.g.reply_time);
        this.aKo = (TextView) view.findViewById(e.g.forum_name);
        this.gCz = (TextView) view.findViewById(e.g.reply_count);
        this.fLb = (LinearLayout) view.findViewById(e.g.item_content);
        this.gCt = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gCu = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.gCs = (LinearLayout) view.findViewById(e.g.person_child);
        this.gCx = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fLb != null) {
            this.fLb.setOnClickListener(this);
        }
        this.eem.setOnClickListener(this);
        this.aKT.setOnClickListener(this);
        this.aKo.setOnClickListener(this);
        this.gCz.setOnClickListener(this);
        this.gCt.setOnClickListener(this);
        this.gCu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gJQ != null) {
            this.gJQ.bO(view);
        }
    }

    public void a(InterfaceC0299a interfaceC0299a) {
        this.gJQ = interfaceC0299a;
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
                str3 = ao.M(postInfoList.create_time * 1000);
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
                str3 = ao.M(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aKT.setText(str2);
            this.aJA.setText(str3);
            this.aKo.setText(str4);
            this.aKo.setTag(str4);
            this.gCz.setText(str5);
            this.aKo.setOnClickListener(this);
            uh(str);
            if (this.fLb != null) {
                this.fLb.setTag(strArr);
            }
            this.gCt.setTag(strArr);
            this.gCu.setTag(strArr);
        }
    }

    private void uh(String str) {
        if (gCw != null && !gCw.equals(str)) {
            gCv = null;
        }
        if (gCv != null) {
            this.eem.setImageBitmap(gCv.ot());
            gCw = str;
            return;
        }
        this.eem.startLoad(str, 12, this.gCx, this.gCx, false);
    }

    public void ey(int i) {
        al.c(this.aKo, e.d.cp_cont_d, 1);
        al.c(this.aJA, e.d.cp_cont_d, 1);
        al.c(this.aKT, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.gCs, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.gCz.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.gCz, e.d.cp_link_tip_c, 1);
    }
}
