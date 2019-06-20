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
    private static com.baidu.adp.widget.ImageView.a ikY;
    private static String ikZ;
    public TextView Xq;
    public TextView bZX;
    public TextView caU;
    public HeadImageView fIM;
    private final LinearLayout hsl;
    public ReplyLinearLayout ikT;
    public TextView ikU;
    protected final LinearLayout ikV;
    protected final ColumnLayout ikW;
    protected final ColumnLayout ikX;
    private int ila;
    public LinearLayout ilb;
    public TextView ilc;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.ikT = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.ikT.setIsHost(this.mIsHost);
        this.ikU = (TextView) view.findViewById(R.id.original_post_title);
        this.ilb = (LinearLayout) view.findViewById(R.id.top_line);
        this.fIM = (HeadImageView) view.findViewById(R.id.portrait);
        this.Xq = (TextView) view.findViewById(R.id.username);
        this.bZX = (TextView) view.findViewById(R.id.reply_time);
        this.caU = (TextView) view.findViewById(R.id.forum_name);
        this.ilc = (TextView) view.findViewById(R.id.reply_count);
        this.hsl = (LinearLayout) view.findViewById(R.id.item_content);
        this.ikW = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ikX = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.ikV = (LinearLayout) view.findViewById(R.id.person_child);
        this.ila = l.dip2px(view.getContext(), 42.0f);
        if (this.hsl != null) {
            this.hsl.setOnClickListener(this);
        }
        this.fIM.setOnClickListener(this);
        this.Xq.setOnClickListener(this);
        this.caU.setOnClickListener(this);
        this.ilc.setOnClickListener(this);
        this.ikW.setOnClickListener(this);
        this.ikX.setOnClickListener(this);
        this.ikU.setOnClickListener(this);
    }

    public void iP(int i) {
        al.k(this.ikU, R.color.cp_bg_line_e);
        al.l(getView(), R.color.cp_bg_line_c);
        al.k(this.ikV, R.drawable.daily_recommend_item_selector);
        al.f(this.Xq, R.color.cp_cont_d, 1);
        al.f(this.bZX, R.color.cp_cont_d, 1);
        al.f(this.caU, R.color.cp_cont_d, 1);
        al.f(this.ilc, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").P("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.caU) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.ikU && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.Xq.setText(str4);
            this.bZX.setText(str3);
            this.caU.setText(str2);
            this.caU.setTag(str2);
            this.ilc.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.caU.setOnClickListener(this);
            Ce(str);
            if (this.hsl != null) {
                this.hsl.setTag(strArr);
            }
            this.ikW.setTag(strArr);
            this.ikX.setTag(strArr);
        }
    }

    private void Ce(String str) {
        if (ikZ != null && !ikZ.equals(str)) {
            ikY = null;
        }
        if (ikY != null) {
            this.fIM.setImageBitmap(ikY.ns());
            ikZ = str;
            return;
        }
        this.fIM.startLoad(str, 12, this.ila, this.ila, false);
    }
}
