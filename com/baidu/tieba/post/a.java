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
    private static com.baidu.adp.widget.ImageView.a gCw;
    private static String gCx;
    public TextView aJB;
    public TextView aKU;
    public TextView aKp;
    public HeadImageView een;
    private final LinearLayout fLc;
    public TextView gCA;
    protected final LinearLayout gCt;
    protected final ColumnLayout gCu;
    protected final ColumnLayout gCv;
    private int gCy;
    public LinearLayout gCz;
    private InterfaceC0299a gJR;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0299a {
        void bO(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gCz = (LinearLayout) view.findViewById(e.g.top_line);
        this.een = (HeadImageView) view.findViewById(e.g.portrait);
        this.aKU = (TextView) view.findViewById(e.g.username);
        this.aJB = (TextView) view.findViewById(e.g.reply_time);
        this.aKp = (TextView) view.findViewById(e.g.forum_name);
        this.gCA = (TextView) view.findViewById(e.g.reply_count);
        this.fLc = (LinearLayout) view.findViewById(e.g.item_content);
        this.gCu = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gCv = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.gCt = (LinearLayout) view.findViewById(e.g.person_child);
        this.gCy = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fLc != null) {
            this.fLc.setOnClickListener(this);
        }
        this.een.setOnClickListener(this);
        this.aKU.setOnClickListener(this);
        this.aKp.setOnClickListener(this);
        this.gCA.setOnClickListener(this);
        this.gCu.setOnClickListener(this);
        this.gCv.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gJR != null) {
            this.gJR.bO(view);
        }
    }

    public void a(InterfaceC0299a interfaceC0299a) {
        this.gJR = interfaceC0299a;
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
            this.aKU.setText(str2);
            this.aJB.setText(str3);
            this.aKp.setText(str4);
            this.aKp.setTag(str4);
            this.gCA.setText(str5);
            this.aKp.setOnClickListener(this);
            uh(str);
            if (this.fLc != null) {
                this.fLc.setTag(strArr);
            }
            this.gCu.setTag(strArr);
            this.gCv.setTag(strArr);
        }
    }

    private void uh(String str) {
        if (gCx != null && !gCx.equals(str)) {
            gCw = null;
        }
        if (gCw != null) {
            this.een.setImageBitmap(gCw.ot());
            gCx = str;
            return;
        }
        this.een.startLoad(str, 12, this.gCy, this.gCy, false);
    }

    public void ey(int i) {
        al.c(this.aKp, e.d.cp_cont_d, 1);
        al.c(this.aJB, e.d.cp_cont_d, 1);
        al.c(this.aKU, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.gCt, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.gCA.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.gCA, e.d.cp_link_tip_c, 1);
    }
}
