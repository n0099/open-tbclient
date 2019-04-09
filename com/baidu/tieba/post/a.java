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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a hSi;
    private static String hSj;
    public TextView Zz;
    public TextView bSe;
    public TextView bTb;
    public HeadImageView fso;
    protected final LinearLayout hSf;
    protected final ColumnLayout hSg;
    protected final ColumnLayout hSh;
    private int hSk;
    public LinearLayout hSl;
    public TextView hSm;
    private final LinearLayout haQ;
    private InterfaceC0370a ibd;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0370a {
        void cB(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hSl = (LinearLayout) view.findViewById(d.g.top_line);
        this.fso = (HeadImageView) view.findViewById(d.g.portrait);
        this.Zz = (TextView) view.findViewById(d.g.username);
        this.bSe = (TextView) view.findViewById(d.g.reply_time);
        this.bTb = (TextView) view.findViewById(d.g.forum_name);
        this.hSm = (TextView) view.findViewById(d.g.reply_count);
        this.haQ = (LinearLayout) view.findViewById(d.g.item_content);
        this.hSg = (ColumnLayout) view.findViewById(d.g.item_header);
        this.hSh = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.hSf = (LinearLayout) view.findViewById(d.g.person_child);
        this.hSk = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.haQ != null) {
            this.haQ.setOnClickListener(this);
        }
        this.fso.setOnClickListener(this);
        this.Zz.setOnClickListener(this);
        this.bTb.setOnClickListener(this);
        this.hSm.setOnClickListener(this);
        this.hSg.setOnClickListener(this);
        this.hSh.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.ibd != null) {
            this.ibd.cB(view);
        }
    }

    public void a(InterfaceC0370a interfaceC0370a) {
        this.ibd = interfaceC0370a;
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
                str3 = ap.ao(postInfoList.create_time * 1000);
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
                str3 = ap.ao(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.Zz.setText(str2);
            this.bSe.setText(str3);
            this.bTb.setText(str4);
            this.bTb.setTag(str4);
            this.hSm.setText(str5);
            this.bTb.setOnClickListener(this);
            AK(str);
            if (this.haQ != null) {
                this.haQ.setTag(strArr);
            }
            this.hSg.setTag(strArr);
            this.hSh.setTag(strArr);
        }
    }

    private void AK(String str) {
        if (hSj != null && !hSj.equals(str)) {
            hSi = null;
        }
        if (hSi != null) {
            this.fso.setImageBitmap(hSi.oy());
            hSj = str;
            return;
        }
        this.fso.startLoad(str, 12, this.hSk, this.hSk, false);
    }

    public void ib(int i) {
        al.d(this.bTb, d.C0277d.cp_cont_d, 1);
        al.d(this.bSe, d.C0277d.cp_cont_d, 1);
        al.d(this.Zz, d.C0277d.cp_cont_f, 1);
        al.k(this.mLayout, d.C0277d.cp_bg_line_c);
        al.k(this.hSf, d.C0277d.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.hSm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this.hSm, d.C0277d.cp_link_tip_c, 1);
    }
}
