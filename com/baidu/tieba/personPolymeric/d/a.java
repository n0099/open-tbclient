package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends q.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gbs;
    private static String gbt;
    public TextView awM;
    public TextView axI;
    public TextView axQ;
    private final LinearLayout fka;
    public ReplyLinearLayout gbn;
    public TextView gbo;
    protected final LinearLayout gbp;
    protected final ColumnLayout gbq;
    protected final ColumnLayout gbr;
    private int gbu;
    public LinearLayout gbv;
    public HeadImageView gbw;
    public TextView gbx;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gbn = (ReplyLinearLayout) view.findViewById(f.g.content_container);
        this.gbn.setIsHost(this.mIsHost);
        this.gbo = (TextView) view.findViewById(f.g.original_post_title);
        this.gbv = (LinearLayout) view.findViewById(f.g.top_line);
        this.gbw = (HeadImageView) view.findViewById(f.g.portrait);
        this.axI = (TextView) view.findViewById(f.g.username);
        this.awM = (TextView) view.findViewById(f.g.reply_time);
        this.axQ = (TextView) view.findViewById(f.g.forum_name);
        this.gbx = (TextView) view.findViewById(f.g.reply_count);
        this.fka = (LinearLayout) view.findViewById(f.g.item_content);
        this.gbq = (ColumnLayout) view.findViewById(f.g.item_header);
        this.gbr = (ColumnLayout) view.findViewById(f.g.item_footer);
        this.gbp = (LinearLayout) view.findViewById(f.g.person_child);
        this.gbu = l.dip2px(view.getContext(), 42.0f);
        if (this.fka != null) {
            this.fka.setOnClickListener(this);
        }
        this.gbw.setOnClickListener(this);
        this.axI.setOnClickListener(this);
        this.axQ.setOnClickListener(this);
        this.gbx.setOnClickListener(this);
        this.gbq.setOnClickListener(this);
        this.gbr.setOnClickListener(this);
        this.gbo.setOnClickListener(this);
    }

    public void dB(int i) {
        am.i(this.gbo, f.d.cp_bg_line_e);
        am.j(getView(), f.d.cp_bg_line_c);
        am.i(this.gbp, f.C0146f.daily_recommend_item_selector);
        am.c(this.axI, f.d.cp_cont_d, 1);
        am.c(this.awM, f.d.cp_cont_d, 1);
        am.c(this.axQ, f.d.cp_cont_d, 1);
        am.c(this.gbx, f.d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.axQ) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.gbo && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
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
        String w;
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
                            w = ap.w(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            w = ap.w(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = w;
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
            this.axI.setText(str4);
            this.awM.setText(str3);
            this.axQ.setText(str2);
            this.axQ.setTag(str2);
            this.gbx.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(f.j.comment_num_tip), str5));
            this.axQ.setOnClickListener(this);
            sa(str);
            if (this.fka != null) {
                this.fka.setTag(strArr);
            }
            this.gbq.setTag(strArr);
            this.gbr.setTag(strArr);
        }
    }

    private void sa(String str) {
        if (gbt != null && !gbt.equals(str)) {
            gbs = null;
        }
        if (gbs != null) {
            this.gbw.setImageBitmap(gbs.nb());
            gbt = str;
            return;
        }
        this.gbw.startLoad(str, 12, this.gbu, this.gbu, false);
    }
}
