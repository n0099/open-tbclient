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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes6.dex */
public class a extends v.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a ikU;
    private static String ikV;
    public TextView Xr;
    public TextView bZW;
    public TextView caT;
    public HeadImageView fIJ;
    private final LinearLayout hsh;
    public ReplyLinearLayout ikP;
    public TextView ikQ;
    protected final LinearLayout ikR;
    protected final ColumnLayout ikS;
    protected final ColumnLayout ikT;
    private int ikW;
    public LinearLayout ikX;
    public TextView ikY;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.ikP = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.ikP.setIsHost(this.mIsHost);
        this.ikQ = (TextView) view.findViewById(R.id.original_post_title);
        this.ikX = (LinearLayout) view.findViewById(R.id.top_line);
        this.fIJ = (HeadImageView) view.findViewById(R.id.portrait);
        this.Xr = (TextView) view.findViewById(R.id.username);
        this.bZW = (TextView) view.findViewById(R.id.reply_time);
        this.caT = (TextView) view.findViewById(R.id.forum_name);
        this.ikY = (TextView) view.findViewById(R.id.reply_count);
        this.hsh = (LinearLayout) view.findViewById(R.id.item_content);
        this.ikS = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ikT = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.ikR = (LinearLayout) view.findViewById(R.id.person_child);
        this.ikW = l.dip2px(view.getContext(), 42.0f);
        if (this.hsh != null) {
            this.hsh.setOnClickListener(this);
        }
        this.fIJ.setOnClickListener(this);
        this.Xr.setOnClickListener(this);
        this.caT.setOnClickListener(this);
        this.ikY.setOnClickListener(this);
        this.ikS.setOnClickListener(this);
        this.ikT.setOnClickListener(this);
        this.ikQ.setOnClickListener(this);
    }

    public void iP(int i) {
        al.k(this.ikQ, R.color.cp_bg_line_e);
        al.l(getView(), R.color.cp_bg_line_c);
        al.k(this.ikR, R.drawable.daily_recommend_item_selector);
        al.f(this.Xr, R.color.cp_cont_d, 1);
        al.f(this.bZW, R.color.cp_cont_d, 1);
        al.f(this.caT, R.color.cp_cont_d, 1);
        al.f(this.ikY, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").P("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.caT) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.ikQ && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f2 */
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
        String aC;
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
                            aC = ap.aC(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            aC = ap.aC(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = aC;
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
            this.Xr.setText(str4);
            this.bZW.setText(str3);
            this.caT.setText(str2);
            this.caT.setTag(str2);
            this.ikY.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.caT.setOnClickListener(this);
            Cc(str);
            if (this.hsh != null) {
                this.hsh.setTag(strArr);
            }
            this.ikS.setTag(strArr);
            this.ikT.setTag(strArr);
        }
    }

    private void Cc(String str) {
        if (ikV != null && !ikV.equals(str)) {
            ikU = null;
        }
        if (ikU != null) {
            this.fIJ.setImageBitmap(ikU.ns());
            ikV = str;
            return;
        }
        this.fIJ.startLoad(str, 12, this.ikW, this.ikW, false);
    }
}
