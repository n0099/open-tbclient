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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a dEb;
    private static String dEc;
    private TbPageContext<?> DV;
    public TextView aZB;
    public TextView adg;
    public TextView cQR;
    private final LinearLayout cwC;
    protected final LinearLayout dDX;
    private final LinearLayout dDY;
    protected final ColumnLayout dDZ;
    protected final ColumnLayout dEa;
    private InterfaceC0070a dEd;
    private int dEe;
    public LinearLayout dEf;
    public HeadImageView dEg;
    public TextView dEh;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void aU(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.DV = tbPageContext;
        this.dEf = (LinearLayout) view.findViewById(t.g.top_line);
        this.dEg = (HeadImageView) view.findViewById(t.g.portrait);
        this.dEh = (TextView) view.findViewById(t.g.username);
        this.adg = (TextView) view.findViewById(t.g.reply_time);
        this.aZB = (TextView) view.findViewById(t.g.forum_name);
        this.cQR = (TextView) view.findViewById(t.g.reply_count);
        this.dDY = (LinearLayout) view.findViewById(t.g.item_content);
        this.dDZ = (ColumnLayout) view.findViewById(t.g.item_header);
        this.dEa = (ColumnLayout) view.findViewById(t.g.item_footer);
        this.cwC = (LinearLayout) view.findViewById(t.g.person_thread);
        this.dDX = (LinearLayout) view.findViewById(t.g.person_child);
        this.dEe = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.dDY != null) {
            this.dDY.setOnClickListener(this);
        }
        this.dEg.setOnClickListener(this);
        this.dEh.setOnClickListener(this);
        this.aZB.setOnClickListener(this);
        this.cQR.setOnClickListener(this);
        this.dDZ.setOnClickListener(this);
        this.dEa.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == t.g.forum_name) {
            if (this.DV != null) {
                this.DV.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.DV.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.dEd != null) {
            this.dEd.aU(view);
        }
    }

    public void a(InterfaceC0070a interfaceC0070a) {
        this.dEd = interfaceC0070a;
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
                            String x = ay.x(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = x;
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
                            str3 = ay.x(postInfoList.create_time * 1000);
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
            this.dEh.setText(str4);
            this.adg.setText(str3);
            this.aZB.setText(str2);
            this.aZB.setTag(str2);
            this.cQR.setText(str6);
            this.aZB.setOnClickListener(this);
            eK(str);
            if (this.dDY != null) {
                this.dDY.setTag(strArr);
            }
            this.dDZ.setTag(strArr);
            this.dEa.setTag(strArr);
        }
    }

    private void eK(String str) {
        if (dEc != null && !dEc.equals(str)) {
            dEb = null;
        }
        if (dEb != null) {
            this.dEg.setImageBitmap(dEb.iY());
            dEc = str;
            return;
        }
        this.dEg.a(str, 12, this.dEe, this.dEe, false);
    }

    public void cR(int i) {
        at.c(this.aZB, t.d.cp_cont_d, 1);
        at.c(this.adg, t.d.cp_cont_d, 1);
        at.c(this.dEh, t.d.cp_cont_f, 1);
        at.k(this.cwC, t.d.cp_bg_line_c);
        at.k(this.dDX, t.f.daily_recommend_item_selector);
        TbadkCoreApplication.m11getInst().getSkinType();
        this.cQR.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        at.c(this.cQR, t.d.cp_link_tip_c, 1);
    }
}
