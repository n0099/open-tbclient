package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes23.dex */
public class d {
    private TextView dNo;
    private View kTM;
    private b kTN;
    private TextView kTO;
    private BarImageView kTP;
    private TextView kTQ;
    private TextView kTR;
    private LinearLayout kTS;
    private HeadImageView kpS;
    private TextView title;

    /* loaded from: classes23.dex */
    public interface b {
        void Oy(String str);

        void dcq();

        void fM(String str, String str2);
    }

    public d(Context context) {
        this.kTM = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.kTM.findViewById(R.id.chosen_pb_title);
        this.kpS = (HeadImageView) this.kTM.findViewById(R.id.chosen_pb_person_info_head);
        this.dNo = (TextView) this.kTM.findViewById(R.id.chosen_pb_person_info_name);
        this.kTO = (TextView) this.kTM.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kpS.setRadius(l.dip2px(context, 2.0f));
        this.kTP = (BarImageView) this.kTM.findViewById(R.id.chosen_pb_bar_pic);
        this.kTQ = (TextView) this.kTM.findViewById(R.id.chosen_pb_bar_attention_number);
        this.kTR = (TextView) this.kTM.findViewById(R.id.chosen_pb_bar_attention_button);
        this.kTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kTN != null) {
                    d.this.kTN.dcq();
                }
            }
        });
        this.kTS = (LinearLayout) this.kTM.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dct() {
        return this.kTM;
    }

    public void a(b bVar) {
        this.kTN = bVar;
    }

    public void OA(String str) {
        if (!StringUtils.isNull(str) && this.kpS != null) {
            this.kpS.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.kTS.setVisibility(8);
                return;
            }
            k.bfo().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.kTS.setVisibility(0);
            aT(context, excellentPbThreadInfo.forum.forum_name);
            if (this.kTP != null) {
                this.kTP.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.kTP.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.kTQ != null && excellentPbThreadInfo.forum.member_count != null) {
                this.kTQ.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                tp(true);
            } else {
                tp(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dNo != null) {
            this.dNo.setText(str);
        }
    }

    private void aT(Context context, String str) {
        if (this.kTO != null) {
            if (StringUtils.isNull(str)) {
                this.kTO.setVisibility(4);
                return;
            }
            this.kTO.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.kTO.setOnClickListener(new a(str));
            this.kTO.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            OA(userInfo.portrait);
            this.kpS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.w(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dNo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.w(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j, String str) {
        if (this.kTN != null) {
            this.kTN.fM(String.valueOf(j), str);
        }
    }

    public void tp(boolean z) {
        if (z) {
            this.kTR.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.kTR, R.color.cp_cont_d, 1);
            this.kTR.setEnabled(false);
            return;
        }
        this.kTR.setText(R.string.attention);
        this.kTR.setEnabled(true);
        ap.setViewTextColor(this.kTR, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.kTN != null) {
                d.this.kTN.Oy(this.forumName);
            }
        }
    }
}
