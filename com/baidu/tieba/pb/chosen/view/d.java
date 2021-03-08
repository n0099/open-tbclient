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
/* loaded from: classes7.dex */
public class d {
    private TextView eoT;
    private View lLC;
    private b lLD;
    private TextView lLE;
    private BarImageView lLF;
    private TextView lLG;
    private TextView lLH;
    private LinearLayout lLI;
    private HeadImageView lhk;
    private TextView title;

    /* loaded from: classes7.dex */
    public interface b {
        void Pn(String str);

        void dlf();

        void fS(String str, String str2);
    }

    public d(Context context) {
        this.lLC = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lLC.findViewById(R.id.chosen_pb_title);
        this.lhk = (HeadImageView) this.lLC.findViewById(R.id.chosen_pb_person_info_head);
        this.eoT = (TextView) this.lLC.findViewById(R.id.chosen_pb_person_info_name);
        this.lLE = (TextView) this.lLC.findViewById(R.id.chosen_pb_bar_forum_name);
        this.lhk.setRadius(l.dip2px(context, 2.0f));
        this.lLF = (BarImageView) this.lLC.findViewById(R.id.chosen_pb_bar_pic);
        this.lLG = (TextView) this.lLC.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lLH = (TextView) this.lLC.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lLD != null) {
                    d.this.lLD.dlf();
                }
            }
        });
        this.lLI = (LinearLayout) this.lLC.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dli() {
        return this.lLC;
    }

    public void a(b bVar) {
        this.lLD = bVar;
    }

    public void Pp(String str) {
        if (!StringUtils.isNull(str) && this.lhk != null) {
            this.lhk.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lLI.setVisibility(8);
                return;
            }
            k.bkV().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lLI.setVisibility(0);
            aZ(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lLF != null) {
                this.lLF.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lLF.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lLG != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lLG.setText(au.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                uE(true);
            } else {
                uE(false);
            }
        }
    }

    public void setName(String str) {
        if (this.eoT != null) {
            this.eoT.setText(str);
        }
    }

    private void aZ(Context context, String str) {
        if (this.lLE != null) {
            if (StringUtils.isNull(str)) {
                this.lLE.setVisibility(4);
                return;
            }
            this.lLE.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lLE.setOnClickListener(new a(str));
            this.lLE.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Pp(userInfo.portrait);
            this.lhk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.z(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.eoT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.z(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, String str) {
        if (this.lLD != null) {
            this.lLD.fS(String.valueOf(j), str);
        }
    }

    public void uE(boolean z) {
        if (z) {
            this.lLH.setText(R.string.relate_forum_is_followed);
            ap.setViewTextColor(this.lLH, R.color.CAM_X0109, 1);
            this.lLH.setEnabled(false);
            return;
        }
        this.lLH.setText(R.string.attention);
        this.lLH.setEnabled(true);
        ap.setViewTextColor(this.lLH, R.color.CAM_X0111, 1);
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
            if (d.this.lLD != null) {
                d.this.lLD.Pn(this.forumName);
            }
        }
    }
}
