package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a dgv;
    private static String dgw;
    private TbPageContext<?> Nw;
    public TextView aPa;
    public TextView ahm;
    private int cGa;
    private final LinearLayout cla;
    public TextView dgA;
    public TextView dgB;
    protected final LinearLayout dgr;
    private final LinearLayout dgs;
    protected final ColumnLayout dgt;
    protected final ColumnLayout dgu;
    private InterfaceC0080a dgx;
    public LinearLayout dgy;
    public HeadImageView dgz;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080a {
        void aI(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.Nw = tbPageContext;
        this.dgy = (LinearLayout) view.findViewById(t.g.top_line);
        this.dgz = (HeadImageView) view.findViewById(t.g.portrait);
        this.dgA = (TextView) view.findViewById(t.g.username);
        this.ahm = (TextView) view.findViewById(t.g.reply_time);
        this.aPa = (TextView) view.findViewById(t.g.forum_name);
        this.dgB = (TextView) view.findViewById(t.g.reply_count);
        this.dgs = (LinearLayout) view.findViewById(t.g.item_content);
        this.dgt = (ColumnLayout) view.findViewById(t.g.item_header);
        this.dgu = (ColumnLayout) view.findViewById(t.g.item_footer);
        this.cla = (LinearLayout) view.findViewById(t.g.person_thread);
        this.dgr = (LinearLayout) view.findViewById(t.g.person_child);
        this.cGa = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.dgs != null) {
            this.dgs.setOnClickListener(this);
        }
        this.dgz.setOnClickListener(this);
        this.dgA.setOnClickListener(this);
        this.aPa.setOnClickListener(this);
        this.dgB.setOnClickListener(this);
        this.dgt.setOnClickListener(this);
        this.dgu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == t.g.forum_name) {
            if (this.Nw != null) {
                this.Nw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Nw.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.dgx != null) {
            this.dgx.aI(view);
        }
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        this.dgx = interfaceC0080a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        String str6 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            String str7 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String t = aw.t(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = t;
                            str2 = str8;
                            str6 = valueOf;
                            str5 = 1;
                        } else {
                            String str9 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str9;
                            str3 = aw.t(postInfoList.create_time * 1000);
                            str2 = postInfoList.forum_name;
                            str6 = String.valueOf(postInfoList.reply_num);
                            str5 = 1;
                        }
                    } catch (Exception e) {
                        str4 = str3;
                        str3 = str2;
                        str2 = str6;
                        str6 = str5;
                        str5 = null;
                        if (str5 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str6 = str5;
                    str4 = str3;
                    str3 = str2;
                    str2 = str6;
                    str6 = str5;
                    str5 = null;
                    if (str5 != null) {
                    }
                }
            } catch (Exception e3) {
                str6 = str5;
                str2 = str5;
                str4 = str3;
                str3 = str2;
                str2 = str6;
                str6 = str5;
                str5 = null;
                if (str5 != null) {
                }
            }
        } catch (Exception e4) {
            str6 = str5;
            str2 = str5;
            str3 = str5;
            str4 = str3;
            str3 = str2;
            str2 = str6;
            str6 = str5;
            str5 = null;
            if (str5 != null) {
            }
        }
        if (str5 != null) {
            this.dgA.setText(str4);
            this.ahm.setText(str3);
            this.aPa.setText(str2);
            this.aPa.setTag(str2);
            this.dgB.setText(str6);
            this.aPa.setOnClickListener(this);
            eG(str);
            if (this.dgs != null) {
                this.dgs.setTag(strArr);
            }
            this.dgt.setTag(strArr);
            this.dgu.setTag(strArr);
        }
    }

    private void eG(String str) {
        if (dgw != null && !dgw.equals(str)) {
            dgv = null;
        }
        if (dgv != null) {
            this.dgz.setImageBitmap(dgv.mS());
            dgw = str;
            return;
        }
        this.dgz.a(str, 12, this.cGa, this.cGa, false);
    }

    public void dg(int i) {
        ar.b(this.aPa, t.d.cp_cont_d, 1);
        ar.b(this.ahm, t.d.cp_cont_d, 1);
        ar.b(this.dgA, t.d.cp_cont_f, 1);
        ar.k(this.cla, t.d.cp_bg_line_c);
        ar.k(this.dgr, t.f.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.dgB.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ar.b(this.dgB, t.d.cp_link_tip_c, 1);
    }
}
