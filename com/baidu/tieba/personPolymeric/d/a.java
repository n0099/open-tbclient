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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes9.dex */
public class a extends v.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a joP;
    private static String joQ;
    public TextView MK;
    public TextView dcZ;
    public TextView ddX;
    public HeadImageView gGt;
    private final LinearLayout iqL;
    public ReplyLinearLayout joK;
    public TextView joL;
    protected final LinearLayout joM;
    protected final ColumnLayout joN;
    protected final ColumnLayout joO;
    private int joR;
    public LinearLayout joS;
    public TextView joT;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.joK = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.joK.setIsHost(this.mIsHost);
        this.joL = (TextView) view.findViewById(R.id.original_post_title);
        this.joS = (LinearLayout) view.findViewById(R.id.top_line);
        this.gGt = (HeadImageView) view.findViewById(R.id.portrait);
        this.MK = (TextView) view.findViewById(R.id.username);
        this.dcZ = (TextView) view.findViewById(R.id.reply_time);
        this.ddX = (TextView) view.findViewById(R.id.forum_name);
        this.joT = (TextView) view.findViewById(R.id.reply_count);
        this.iqL = (LinearLayout) view.findViewById(R.id.item_content);
        this.joN = (ColumnLayout) view.findViewById(R.id.item_header);
        this.joO = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.joM = (LinearLayout) view.findViewById(R.id.person_child);
        this.joR = l.dip2px(view.getContext(), 42.0f);
        if (this.iqL != null) {
            this.iqL.setOnClickListener(this);
        }
        this.gGt.setOnClickListener(this);
        this.MK.setOnClickListener(this);
        this.ddX.setOnClickListener(this);
        this.joT.setOnClickListener(this);
        this.joN.setOnClickListener(this);
        this.joO.setOnClickListener(this);
        this.joL.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        am.setBackgroundResource(this.joL, R.color.cp_bg_line_e);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_c);
        am.setBackgroundResource(this.joM, R.drawable.daily_recommend_item_selector);
        am.setViewTextColor(this.MK, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.dcZ, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.ddX, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.joT, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").Z("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.ddX) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.joL && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
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
        String formatTime;
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
                            formatTime = aq.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            formatTime = aq.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = formatTime;
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
            this.MK.setText(str4);
            this.dcZ.setText(str3);
            this.ddX.setText(str2);
            this.ddX.setTag(str2);
            this.joT.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.ddX.setOnClickListener(this);
            GH(str);
            if (this.iqL != null) {
                this.iqL.setTag(strArr);
            }
            this.joN.setTag(strArr);
            this.joO.setTag(strArr);
        }
    }

    private void GH(String str) {
        if (joQ != null && !joQ.equals(str)) {
            joP = null;
        }
        if (joP != null) {
            this.gGt.setImageBitmap(joP.getRawBitmap());
            joQ = str;
            return;
        }
        this.gGt.a(str, 12, this.joR, this.joR, false);
    }
}
