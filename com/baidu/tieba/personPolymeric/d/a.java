package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes6.dex */
public class a extends v.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a hSv;
    private static String hSw;
    public TextView Zy;
    public TextView bSY;
    public TextView bSb;
    public HeadImageView fsC;
    public ReplyLinearLayout hSq;
    public TextView hSr;
    protected final LinearLayout hSs;
    protected final ColumnLayout hSt;
    protected final ColumnLayout hSu;
    private int hSx;
    public LinearLayout hSy;
    public TextView hSz;
    private final LinearLayout hbc;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.hSq = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.hSq.setIsHost(this.mIsHost);
        this.hSr = (TextView) view.findViewById(d.g.original_post_title);
        this.hSy = (LinearLayout) view.findViewById(d.g.top_line);
        this.fsC = (HeadImageView) view.findViewById(d.g.portrait);
        this.Zy = (TextView) view.findViewById(d.g.username);
        this.bSb = (TextView) view.findViewById(d.g.reply_time);
        this.bSY = (TextView) view.findViewById(d.g.forum_name);
        this.hSz = (TextView) view.findViewById(d.g.reply_count);
        this.hbc = (LinearLayout) view.findViewById(d.g.item_content);
        this.hSt = (ColumnLayout) view.findViewById(d.g.item_header);
        this.hSu = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.hSs = (LinearLayout) view.findViewById(d.g.person_child);
        this.hSx = l.dip2px(view.getContext(), 42.0f);
        if (this.hbc != null) {
            this.hbc.setOnClickListener(this);
        }
        this.fsC.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.bSY.setOnClickListener(this);
        this.hSz.setOnClickListener(this);
        this.hSt.setOnClickListener(this);
        this.hSu.setOnClickListener(this);
        this.hSr.setOnClickListener(this);
    }

    public void ic(int i) {
        al.k(this.hSr, d.C0277d.cp_bg_line_e);
        al.l(getView(), d.C0277d.cp_bg_line_c);
        al.k(this.hSs, d.f.daily_recommend_item_selector);
        al.d(this.Zy, d.C0277d.cp_cont_d, 1);
        al.d(this.bSb, d.C0277d.cp_cont_d, 1);
        al.d(this.bSY, d.C0277d.cp_cont_d, 1);
        al.d(this.hSz, d.C0277d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").T("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.bSY) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.hSr && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
        String ao;
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
                            ao = ap.ao(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            ao = ap.ao(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = ao;
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
            this.Zy.setText(str4);
            this.bSb.setText(str3);
            this.bSY.setText(str2);
            this.bSY.setTag(str2);
            this.hSz.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.j.comment_num_tip), str5));
            this.bSY.setOnClickListener(this);
            AL(str);
            if (this.hbc != null) {
                this.hbc.setTag(strArr);
            }
            this.hSt.setTag(strArr);
            this.hSu.setTag(strArr);
        }
    }

    private void AL(String str) {
        if (hSw != null && !hSw.equals(str)) {
            hSv = null;
        }
        if (hSv != null) {
            this.fsC.setImageBitmap(hSv.oy());
            hSw = str;
            return;
        }
        this.fsC.startLoad(str, 12, this.hSx, this.hSx, false);
    }
}
