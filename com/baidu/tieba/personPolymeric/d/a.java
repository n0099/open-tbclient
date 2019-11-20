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
/* loaded from: classes6.dex */
public class a extends v.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a isd;
    private static String ise;
    public TextView He;
    public TextView cpw;
    public TextView cqt;
    public HeadImageView fOR;
    private final LinearLayout hzd;
    public ReplyLinearLayout irY;
    public TextView irZ;
    protected final LinearLayout isa;
    protected final ColumnLayout isb;
    protected final ColumnLayout isc;
    private int isf;
    public LinearLayout isg;
    public TextView ish;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.irY = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.irY.setIsHost(this.mIsHost);
        this.irZ = (TextView) view.findViewById(R.id.original_post_title);
        this.isg = (LinearLayout) view.findViewById(R.id.top_line);
        this.fOR = (HeadImageView) view.findViewById(R.id.portrait);
        this.He = (TextView) view.findViewById(R.id.username);
        this.cpw = (TextView) view.findViewById(R.id.reply_time);
        this.cqt = (TextView) view.findViewById(R.id.forum_name);
        this.ish = (TextView) view.findViewById(R.id.reply_count);
        this.hzd = (LinearLayout) view.findViewById(R.id.item_content);
        this.isb = (ColumnLayout) view.findViewById(R.id.item_header);
        this.isc = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.isa = (LinearLayout) view.findViewById(R.id.person_child);
        this.isf = l.dip2px(view.getContext(), 42.0f);
        if (this.hzd != null) {
            this.hzd.setOnClickListener(this);
        }
        this.fOR.setOnClickListener(this);
        this.He.setOnClickListener(this);
        this.cqt.setOnClickListener(this);
        this.ish.setOnClickListener(this);
        this.isb.setOnClickListener(this);
        this.isc.setOnClickListener(this);
        this.irZ.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        am.setBackgroundResource(this.irZ, R.color.cp_bg_line_e);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_c);
        am.setBackgroundResource(this.isa, R.drawable.daily_recommend_item_selector);
        am.setViewTextColor(this.He, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.cpw, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.cqt, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.ish, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new an("c12043").O("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.cqt) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.irZ && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.He.setText(str4);
            this.cpw.setText(str3);
            this.cqt.setText(str2);
            this.cqt.setTag(str2);
            this.ish.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.cqt.setOnClickListener(this);
            BK(str);
            if (this.hzd != null) {
                this.hzd.setTag(strArr);
            }
            this.isb.setTag(strArr);
            this.isc.setTag(strArr);
        }
    }

    private void BK(String str) {
        if (ise != null && !ise.equals(str)) {
            isd = null;
        }
        if (isd != null) {
            this.fOR.setImageBitmap(isd.getRawBitmap());
            ise = str;
            return;
        }
        this.fOR.a(str, 12, this.isf, this.isf, false);
    }
}
