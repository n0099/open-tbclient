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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a cqZ;
    private static String cra;
    public TextView aNr;
    public TextView aSV;
    private final LinearLayout bMQ;
    private int ccF;
    protected final LinearLayout cqV;
    private final LinearLayout cqW;
    protected final ColumnLayout cqX;
    protected final ColumnLayout cqY;
    private InterfaceC0072a crb;
    public LinearLayout crc;
    public HeadImageView crd;
    public TextView cre;
    public TextView crf;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void ae(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.crc = (LinearLayout) view.findViewById(i.f.top_line);
        this.crd = (HeadImageView) view.findViewById(i.f.portrait);
        this.cre = (TextView) view.findViewById(i.f.username);
        this.aSV = (TextView) view.findViewById(i.f.reply_time);
        this.aNr = (TextView) view.findViewById(i.f.forum_name);
        this.crf = (TextView) view.findViewById(i.f.reply_count);
        this.cqW = (LinearLayout) view.findViewById(i.f.item_content);
        this.cqX = (ColumnLayout) view.findViewById(i.f.item_header);
        this.cqY = (ColumnLayout) view.findViewById(i.f.item_footer);
        this.bMQ = (LinearLayout) view.findViewById(i.f.person_thread);
        this.cqV = (LinearLayout) view.findViewById(i.f.person_child);
        this.ccF = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.cqW != null) {
            this.cqW.setOnClickListener(this);
        }
        this.crd.setOnClickListener(this);
        this.cre.setOnClickListener(this);
        this.aSV.setOnClickListener(this);
        this.aNr.setOnClickListener(this);
        this.crf.setOnClickListener(this);
        this.cqX.setOnClickListener(this);
        this.cqY.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.crb != null) {
            this.crb.ae(view);
        }
    }

    public void a(InterfaceC0072a interfaceC0072a) {
        this.crb = interfaceC0072a;
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
                            String o = ar.o(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = o;
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
                            str3 = ar.o(postInfoList.create_time * 1000);
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
            this.cre.setText(str4);
            this.aSV.setText(str3);
            this.aNr.setText(str2);
            this.aNr.setTag(str2);
            this.crf.setText(str6);
            this.aNr.setOnClickListener(this);
            eu(str);
            if (this.cqW != null) {
                this.cqW.setTag(strArr);
            }
            this.cqX.setTag(strArr);
            this.cqY.setTag(strArr);
        }
    }

    private void eu(String str) {
        if (cra != null && !cra.equals(str)) {
            cqZ = null;
        }
        if (cqZ != null) {
            this.crd.setImageBitmap(cqZ.na());
            cra = str;
            return;
        }
        this.crd.a(str, 12, this.ccF, this.ccF, false);
    }

    public void cN(int i) {
        am.b(this.aNr, i.c.cp_cont_d, 1);
        am.b(this.aSV, i.c.cp_cont_d, 1);
        am.b(this.cre, i.c.cp_cont_f, 1);
        am.i(this.bMQ, i.c.cp_bg_line_c);
        am.i(this.cqV, i.e.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.crf.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.b(this.crf, i.c.cp_link_tip_c, 1);
    }
}
