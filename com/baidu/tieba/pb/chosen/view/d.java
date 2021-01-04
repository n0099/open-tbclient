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
/* loaded from: classes8.dex */
public class d {
    private TextView epX;
    private View lFf;
    private b lFg;
    private TextView lFh;
    private BarImageView lFi;
    private TextView lFj;
    private TextView lFk;
    private LinearLayout lFl;
    private HeadImageView lbw;
    private TextView title;

    /* loaded from: classes8.dex */
    public interface b {
        void Px(String str);

        void dmu();

        void fT(String str, String str2);
    }

    public d(Context context) {
        this.lFf = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lFf.findViewById(R.id.chosen_pb_title);
        this.lbw = (HeadImageView) this.lFf.findViewById(R.id.chosen_pb_person_info_head);
        this.epX = (TextView) this.lFf.findViewById(R.id.chosen_pb_person_info_name);
        this.lFh = (TextView) this.lFf.findViewById(R.id.chosen_pb_bar_forum_name);
        this.lbw.setRadius(l.dip2px(context, 2.0f));
        this.lFi = (BarImageView) this.lFf.findViewById(R.id.chosen_pb_bar_pic);
        this.lFj = (TextView) this.lFf.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lFk = (TextView) this.lFf.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lFg != null) {
                    d.this.lFg.dmu();
                }
            }
        });
        this.lFl = (LinearLayout) this.lFf.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dmx() {
        return this.lFf;
    }

    public void a(b bVar) {
        this.lFg = bVar;
    }

    public void Pz(String str) {
        if (!StringUtils.isNull(str) && this.lbw != null) {
            this.lbw.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lFl.setVisibility(8);
                return;
            }
            k.bou().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lFl.setVisibility(0);
            bc(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lFi != null) {
                this.lFi.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lFi.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lFj != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lFj.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                uv(true);
            } else {
                uv(false);
            }
        }
    }

    public void setName(String str) {
        if (this.epX != null) {
            this.epX.setText(str);
        }
    }

    private void bc(Context context, String str) {
        if (this.lFh != null) {
            if (StringUtils.isNull(str)) {
                this.lFh.setVisibility(4);
                return;
            }
            this.lFh.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lFh.setOnClickListener(new a(str));
            this.lFh.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Pz(userInfo.portrait);
            this.lbw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.y(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.epX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.y(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j, String str) {
        if (this.lFg != null) {
            this.lFg.fT(String.valueOf(j), str);
        }
    }

    public void uv(boolean z) {
        if (z) {
            this.lFk.setText(R.string.relate_forum_is_followed);
            ao.setViewTextColor(this.lFk, R.color.CAM_X0109, 1);
            this.lFk.setEnabled(false);
            return;
        }
        this.lFk.setText(R.string.attention);
        this.lFk.setEnabled(true);
        ao.setViewTextColor(this.lFk, R.color.CAM_X0111, 1);
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
            if (d.this.lFg != null) {
                d.this.lFg.Px(this.forumName);
            }
        }
    }
}
