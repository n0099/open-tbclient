package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.ReplyLinearLayout;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* loaded from: classes.dex */
public class a extends j.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a fht;
    private static String fhu;
    public TextView amI;
    public TextView anF;
    private View bAO;
    public TextView bKm;
    private View bMb;
    public TextView egO;
    private final LinearLayout erq;
    public ReplyLinearLayout fho;
    public TextView fhp;
    protected final LinearLayout fhq;
    protected final ColumnLayout fhr;
    protected final ColumnLayout fhs;
    private int fhv;
    public LinearLayout fhw;
    public HeadImageView fhx;
    private TbPageContext<?> mG;
    private boolean mIsHost;
    private final LinearLayout mLayout;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mG = tbPageContext;
        this.mIsHost = z;
        this.fho = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.fho.setIsHost(this.mIsHost);
        this.fhp = (TextView) view.findViewById(d.h.original_post_title);
        this.bMb = view.findViewById(d.h.reply_top_line);
        this.bAO = view.findViewById(d.h.reply_bottom_line);
        this.fhw = (LinearLayout) view.findViewById(d.h.top_line);
        this.fhx = (HeadImageView) view.findViewById(d.h.portrait);
        this.anF = (TextView) view.findViewById(d.h.username);
        this.amI = (TextView) view.findViewById(d.h.reply_time);
        this.bKm = (TextView) view.findViewById(d.h.forum_name);
        this.egO = (TextView) view.findViewById(d.h.reply_count);
        this.erq = (LinearLayout) view.findViewById(d.h.item_content);
        this.fhr = (ColumnLayout) view.findViewById(d.h.item_header);
        this.fhs = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.fhq = (LinearLayout) view.findViewById(d.h.person_child);
        this.fhv = l.dip2px(view.getContext(), 42.0f);
        if (this.erq != null) {
            this.erq.setOnClickListener(this);
        }
        this.fhx.setOnClickListener(this);
        this.anF.setOnClickListener(this);
        this.bKm.setOnClickListener(this);
        this.egO.setOnClickListener(this);
        this.fhr.setOnClickListener(this);
        this.fhs.setOnClickListener(this);
        this.fhp.setOnClickListener(this);
    }

    public void dz(int i) {
        aj.j(this.fhp, d.e.cp_bg_line_e);
        aj.k(getView(), d.e.cp_bg_line_c);
        aj.j(this.fhq, d.g.daily_recommend_item_selector);
        aj.c(this.anF, d.e.cp_cont_d, 1);
        aj.c(this.amI, d.e.cp_cont_d, 1);
        aj.c(this.bKm, d.e.cp_cont_d, 1);
        aj.c(this.egO, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.bKm) {
            if (this.mG != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mG.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fhp && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mG.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String q;
        String str7;
        String valueOf;
        String str8 = null;
        String str9 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            q = am.q(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            q = am.q(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = q;
                        str2 = str7;
                        str9 = valueOf;
                        str8 = 1;
                        str5 = str9;
                    } catch (Exception e) {
                        str9 = str8;
                        str4 = str3;
                        str3 = str2;
                        str2 = str9;
                        str5 = str8;
                        str8 = null;
                        if (str8 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str9 = str8;
                    str2 = str8;
                    str4 = str3;
                    str3 = str2;
                    str2 = str9;
                    str5 = str8;
                    str8 = null;
                    if (str8 != null) {
                    }
                }
            } catch (Exception e3) {
                str9 = 0;
                str2 = null;
                str3 = null;
                str4 = str3;
                str3 = str2;
                str2 = str9;
                str5 = str8;
                str8 = null;
                if (str8 != null) {
                }
            }
        } catch (Exception e4) {
            str4 = str3;
            str3 = str2;
            str2 = str9;
            str5 = str8;
            str8 = null;
            if (str8 != null) {
            }
        }
        if (str8 != null) {
            this.anF.setText(str4);
            this.amI.setText(str3);
            this.bKm.setText(str2);
            this.bKm.setTag(str2);
            this.egO.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bKm.setOnClickListener(this);
            fb(str);
            if (this.erq != null) {
                this.erq.setTag(strArr);
            }
            this.fhr.setTag(strArr);
            this.fhs.setTag(strArr);
        }
    }

    private void fb(String str) {
        if (fhu != null && !fhu.equals(str)) {
            fht = null;
        }
        if (fht != null) {
            this.fhx.setImageBitmap(fht.kN());
            fhu = str;
            return;
        }
        this.fhx.a(str, 12, this.fhv, this.fhv, false);
    }
}
