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
/* loaded from: classes22.dex */
public class d {
    private TextView dZV;
    private HeadImageView kIy;
    private BarImageView lmA;
    private TextView lmB;
    private TextView lmC;
    private LinearLayout lmD;
    private View lmx;
    private b lmy;
    private TextView lmz;
    private TextView title;

    /* loaded from: classes22.dex */
    public interface b {
        void OJ(String str);

        void dhx();

        void fR(String str, String str2);
    }

    public d(Context context) {
        this.lmx = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lmx.findViewById(R.id.chosen_pb_title);
        this.kIy = (HeadImageView) this.lmx.findViewById(R.id.chosen_pb_person_info_head);
        this.dZV = (TextView) this.lmx.findViewById(R.id.chosen_pb_person_info_name);
        this.lmz = (TextView) this.lmx.findViewById(R.id.chosen_pb_bar_forum_name);
        this.kIy.setRadius(l.dip2px(context, 2.0f));
        this.lmA = (BarImageView) this.lmx.findViewById(R.id.chosen_pb_bar_pic);
        this.lmB = (TextView) this.lmx.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lmC = (TextView) this.lmx.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lmy != null) {
                    d.this.lmy.dhx();
                }
            }
        });
        this.lmD = (LinearLayout) this.lmx.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dhA() {
        return this.lmx;
    }

    public void a(b bVar) {
        this.lmy = bVar;
    }

    public void OL(String str) {
        if (!StringUtils.isNull(str) && this.kIy != null) {
            this.kIy.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lmD.setVisibility(8);
                return;
            }
            k.biL().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lmD.setVisibility(0);
            aS(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lmA != null) {
                this.lmA.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lmA.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lmB != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lmB.setText(au.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                tS(true);
            } else {
                tS(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dZV != null) {
            this.dZV.setText(str);
        }
    }

    private void aS(Context context, String str) {
        if (this.lmz != null) {
            if (StringUtils.isNull(str)) {
                this.lmz.setVisibility(4);
                return;
            }
            this.lmz.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lmz.setOnClickListener(new a(str));
            this.lmz.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            OL(userInfo.portrait);
            this.kIy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.x(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dZV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.x(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(long j, String str) {
        if (this.lmy != null) {
            this.lmy.fR(String.valueOf(j), str);
        }
    }

    public void tS(boolean z) {
        if (z) {
            this.lmC.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lmC, R.color.CAM_X0109, 1);
            this.lmC.setEnabled(false);
            return;
        }
        this.lmC.setText(R.string.attention);
        this.lmC.setEnabled(true);
        ap.setViewTextColor(this.lmC, R.color.CAM_X0111, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.lmy != null) {
                d.this.lmy.OJ(this.forumName);
            }
        }
    }
}
