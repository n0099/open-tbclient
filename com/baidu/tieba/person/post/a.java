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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a cUV;
    private static String cUW;
    public TextView aNz;
    public TextView agy;
    protected final LinearLayout cUR;
    private final LinearLayout cUS;
    protected final ColumnLayout cUT;
    protected final ColumnLayout cUU;
    private InterfaceC0077a cUX;
    public LinearLayout cUY;
    public HeadImageView cUZ;
    public TextView cVa;
    public TextView cVb;
    private final LinearLayout cgA;
    private int czt;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0077a {
        void as(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cUY = (LinearLayout) view.findViewById(n.g.top_line);
        this.cUZ = (HeadImageView) view.findViewById(n.g.portrait);
        this.cVa = (TextView) view.findViewById(n.g.username);
        this.agy = (TextView) view.findViewById(n.g.reply_time);
        this.aNz = (TextView) view.findViewById(n.g.forum_name);
        this.cVb = (TextView) view.findViewById(n.g.reply_count);
        this.cUS = (LinearLayout) view.findViewById(n.g.item_content);
        this.cUT = (ColumnLayout) view.findViewById(n.g.item_header);
        this.cUU = (ColumnLayout) view.findViewById(n.g.item_footer);
        this.cgA = (LinearLayout) view.findViewById(n.g.person_thread);
        this.cUR = (LinearLayout) view.findViewById(n.g.person_child);
        this.czt = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.cUS != null) {
            this.cUS.setOnClickListener(this);
        }
        this.cUZ.setOnClickListener(this);
        this.cVa.setOnClickListener(this);
        this.aNz.setOnClickListener(this);
        this.cVb.setOnClickListener(this);
        this.cUT.setOnClickListener(this);
        this.cUU.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.cUX != null) {
            this.cUX.as(view);
        }
    }

    public void a(InterfaceC0077a interfaceC0077a) {
        this.cUX = interfaceC0077a;
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
                            String s = ax.s(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = s;
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
                            str3 = ax.s(postInfoList.create_time * 1000);
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
            this.cVa.setText(str4);
            this.agy.setText(str3);
            this.aNz.setText(str2);
            this.aNz.setTag(str2);
            this.cVb.setText(str6);
            this.aNz.setOnClickListener(this);
            eH(str);
            if (this.cUS != null) {
                this.cUS.setTag(strArr);
            }
            this.cUT.setTag(strArr);
            this.cUU.setTag(strArr);
        }
    }

    private void eH(String str) {
        if (cUW != null && !cUW.equals(str)) {
            cUV = null;
        }
        if (cUV != null) {
            this.cUZ.setImageBitmap(cUV.mE());
            cUW = str;
            return;
        }
        this.cUZ.a(str, 12, this.czt, this.czt, false);
    }

    public void cP(int i) {
        as.b(this.aNz, n.d.cp_cont_d, 1);
        as.b(this.agy, n.d.cp_cont_d, 1);
        as.b(this.cVa, n.d.cp_cont_f, 1);
        as.i(this.cgA, n.d.cp_bg_line_c);
        as.i(this.cUR, n.f.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.cVb.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        as.b(this.cVb, n.d.cp_link_tip_c, 1);
    }
}
