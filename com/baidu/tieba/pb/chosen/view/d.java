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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes8.dex */
public class d {
    private TextView enq;
    private View lJA;
    private b lJB;
    private TextView lJC;
    private BarImageView lJD;
    private TextView lJE;
    private TextView lJF;
    private LinearLayout lJG;
    private HeadImageView lfi;
    private TextView title;

    /* loaded from: classes8.dex */
    public interface b {
        void Ph(String str);

        void dkW();

        void fS(String str, String str2);
    }

    public d(Context context) {
        this.lJA = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lJA.findViewById(R.id.chosen_pb_title);
        this.lfi = (HeadImageView) this.lJA.findViewById(R.id.chosen_pb_person_info_head);
        this.enq = (TextView) this.lJA.findViewById(R.id.chosen_pb_person_info_name);
        this.lJC = (TextView) this.lJA.findViewById(R.id.chosen_pb_bar_forum_name);
        this.lfi.setRadius(l.dip2px(context, 2.0f));
        this.lJD = (BarImageView) this.lJA.findViewById(R.id.chosen_pb_bar_pic);
        this.lJE = (TextView) this.lJA.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lJF = (TextView) this.lJA.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lJB != null) {
                    d.this.lJB.dkW();
                }
            }
        });
        this.lJG = (LinearLayout) this.lJA.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dkZ() {
        return this.lJA;
    }

    public void a(b bVar) {
        this.lJB = bVar;
    }

    public void Pj(String str) {
        if (!StringUtils.isNull(str) && this.lfi != null) {
            this.lfi.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lJG.setVisibility(8);
                return;
            }
            k.bkT().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lJG.setVisibility(0);
            aZ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lJD != null) {
                this.lJD.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lJD.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lJE != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lJE.setText(au.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                uE(true);
            } else {
                uE(false);
            }
        }
    }

    public void setName(String str) {
        if (this.enq != null) {
            this.enq.setText(str);
        }
    }

    private void aZ(Context context, String str) {
        if (this.lJC != null) {
            if (StringUtils.isNull(str)) {
                this.lJC.setVisibility(4);
                return;
            }
            this.lJC.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lJC.setOnClickListener(new a(str));
            this.lJC.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Pj(userInfo.portrait);
            this.lfi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.z(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.enq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.z(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, String str) {
        if (this.lJB != null) {
            this.lJB.fS(String.valueOf(j), str);
        }
    }

    public void uE(boolean z) {
        if (z) {
            this.lJF.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lJF, R.color.CAM_X0109, 1);
            this.lJF.setEnabled(false);
            return;
        }
        this.lJF.setText(R.string.attention);
        this.lJF.setEnabled(true);
        ap.setViewTextColor(this.lJF, R.color.CAM_X0111, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.lJB != null) {
                d.this.lJB.Ph(this.forumName);
            }
        }
    }
}
