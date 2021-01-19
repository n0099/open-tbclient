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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes7.dex */
public class d {
    private TextView eli;
    private HeadImageView kWQ;
    private b lAA;
    private TextView lAB;
    private BarImageView lAC;
    private TextView lAD;
    private TextView lAE;
    private LinearLayout lAF;
    private View lAz;
    private TextView title;

    /* loaded from: classes7.dex */
    public interface b {
        void Op(String str);

        void diD();

        void fS(String str, String str2);
    }

    public d(Context context) {
        this.lAz = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lAz.findViewById(R.id.chosen_pb_title);
        this.kWQ = (HeadImageView) this.lAz.findViewById(R.id.chosen_pb_person_info_head);
        this.eli = (TextView) this.lAz.findViewById(R.id.chosen_pb_person_info_name);
        this.lAB = (TextView) this.lAz.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kWQ.setRadius(l.dip2px(context, 2.0f));
        this.lAC = (BarImageView) this.lAz.findViewById(R.id.chosen_pb_bar_pic);
        this.lAD = (TextView) this.lAz.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lAE = (TextView) this.lAz.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lAE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lAA != null) {
                    d.this.lAA.diD();
                }
            }
        });
        this.lAF = (LinearLayout) this.lAz.findViewById(R.id.chosen_pb_bar_container);
    }

    public View diG() {
        return this.lAz;
    }

    public void a(b bVar) {
        this.lAA = bVar;
    }

    public void Or(String str) {
        if (!StringUtils.isNull(str) && this.kWQ != null) {
            this.kWQ.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lAF.setVisibility(8);
                return;
            }
            k.bkB().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lAF.setVisibility(0);
            bc(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lAC != null) {
                this.lAC.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lAC.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lAD != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lAD.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                ur(true);
            } else {
                ur(false);
            }
        }
    }

    public void setName(String str) {
        if (this.eli != null) {
            this.eli.setText(str);
        }
    }

    private void bc(Context context, String str) {
        if (this.lAB != null) {
            if (StringUtils.isNull(str)) {
                this.lAB.setVisibility(4);
                return;
            }
            this.lAB.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lAB.setOnClickListener(new a(str));
            this.lAB.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Or(userInfo.portrait);
            this.kWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.y(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.eli.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.y(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, String str) {
        if (this.lAA != null) {
            this.lAA.fS(String.valueOf(j), str);
        }
    }

    public void ur(boolean z) {
        if (z) {
            this.lAE.setText(R.string.relate_forum_is_followed);
            ao.setViewTextColor(this.lAE, R.color.CAM_X0109, 1);
            this.lAE.setEnabled(false);
            return;
        }
        this.lAE.setText(R.string.attention);
        this.lAE.setEnabled(true);
        ao.setViewTextColor(this.lAE, R.color.CAM_X0111, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.lAA != null) {
                d.this.lAA.Op(this.forumName);
            }
        }
    }
}
