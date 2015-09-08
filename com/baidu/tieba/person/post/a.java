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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a clv;
    private static String clw;
    public TextView aOv;
    public TextView aTZ;
    private final LinearLayout bJL;
    private int bYT;
    public TextView clA;
    public TextView clB;
    protected final LinearLayout clr;
    private final LinearLayout cls;
    protected final ColumnLayout clt;
    protected final ColumnLayout clu;
    private InterfaceC0069a clx;
    public LinearLayout cly;
    public HeadImageView clz;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0069a {
        void ac(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cly = (LinearLayout) view.findViewById(i.f.top_line);
        this.clz = (HeadImageView) view.findViewById(i.f.portrait);
        this.clA = (TextView) view.findViewById(i.f.username);
        this.aTZ = (TextView) view.findViewById(i.f.reply_time);
        this.aOv = (TextView) view.findViewById(i.f.forum_name);
        this.clB = (TextView) view.findViewById(i.f.reply_count);
        this.cls = (LinearLayout) view.findViewById(i.f.item_content);
        this.clt = (ColumnLayout) view.findViewById(i.f.item_header);
        this.clu = (ColumnLayout) view.findViewById(i.f.item_footer);
        this.bJL = (LinearLayout) view.findViewById(i.f.person_thread);
        this.clr = (LinearLayout) view.findViewById(i.f.person_child);
        this.bYT = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.cls != null) {
            this.cls.setOnClickListener(this);
        }
        this.clz.setOnClickListener(this);
        this.clA.setOnClickListener(this);
        this.aTZ.setOnClickListener(this);
        this.aOv.setOnClickListener(this);
        this.clB.setOnClickListener(this);
        this.clt.setOnClickListener(this);
        this.clu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.clx != null) {
            this.clx.ac(view);
        }
    }

    public void a(InterfaceC0069a interfaceC0069a) {
        this.clx = interfaceC0069a;
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
                            String m = aq.m(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = m;
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
                            str3 = aq.m(postInfoList.create_time * 1000);
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
            this.clA.setText(str4);
            this.aTZ.setText(str3);
            this.aOv.setText(str2);
            this.aOv.setTag(str2);
            this.clB.setText(str6);
            this.aOv.setOnClickListener(this);
            es(str);
            if (this.cls != null) {
                this.cls.setTag(strArr);
            }
            this.clt.setTag(strArr);
            this.clu.setTag(strArr);
        }
    }

    private void es(String str) {
        if (clw != null && !clw.equals(str)) {
            clv = null;
        }
        if (clv != null) {
            this.clz.setImageBitmap(clv.mZ());
            clw = str;
            return;
        }
        this.clz.a(str, 12, this.bYT, this.bYT, false);
    }

    public void cM(int i) {
        al.b(this.aOv, i.c.cp_cont_d, 1);
        al.b(this.aTZ, i.c.cp_cont_d, 1);
        al.b(this.clA, i.c.cp_cont_f, 1);
        al.h(this.bJL, i.c.cp_bg_line_c);
        al.h(this.clr, i.e.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.clB.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(i.e.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.b(this.clB, i.c.cp_link_tip_c, 1);
    }
}
