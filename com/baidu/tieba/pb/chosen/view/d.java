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
    private View lFe;
    private b lFf;
    private TextView lFg;
    private BarImageView lFh;
    private TextView lFi;
    private TextView lFj;
    private LinearLayout lFk;
    private HeadImageView lbw;
    private TextView title;

    /* loaded from: classes8.dex */
    public interface b {
        void Pw(String str);

        void dmv();

        void fT(String str, String str2);
    }

    public d(Context context) {
        this.lFe = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.lFe.findViewById(R.id.chosen_pb_title);
        this.lbw = (HeadImageView) this.lFe.findViewById(R.id.chosen_pb_person_info_head);
        this.epX = (TextView) this.lFe.findViewById(R.id.chosen_pb_person_info_name);
        this.lFg = (TextView) this.lFe.findViewById(R.id.chosen_pb_bar_forum_name);
        this.lbw.setRadius(l.dip2px(context, 2.0f));
        this.lFh = (BarImageView) this.lFe.findViewById(R.id.chosen_pb_bar_pic);
        this.lFi = (TextView) this.lFe.findViewById(R.id.chosen_pb_bar_attention_number);
        this.lFj = (TextView) this.lFe.findViewById(R.id.chosen_pb_bar_attention_button);
        this.lFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.lFf != null) {
                    d.this.lFf.dmv();
                }
            }
        });
        this.lFk = (LinearLayout) this.lFe.findViewById(R.id.chosen_pb_bar_container);
    }

    public View dmy() {
        return this.lFe;
    }

    public void a(b bVar) {
        this.lFf = bVar;
    }

    public void Py(String str) {
        if (!StringUtils.isNull(str) && this.lbw != null) {
            this.lbw.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.lFk.setVisibility(8);
                return;
            }
            k.bov().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.lFk.setVisibility(0);
            bc(context, excellentPbThreadInfo.forum.forum_name);
            if (this.lFh != null) {
                this.lFh.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.lFh.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.lFi != null && excellentPbThreadInfo.forum.member_count != null) {
                this.lFi.setText(at.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
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
        if (this.lFg != null) {
            if (StringUtils.isNull(str)) {
                this.lFg.setVisibility(4);
                return;
            }
            this.lFg.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.lFg.setOnClickListener(new a(str));
            this.lFg.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Py(userInfo.portrait);
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
        if (this.lFf != null) {
            this.lFf.fT(String.valueOf(j), str);
        }
    }

    public void uv(boolean z) {
        if (z) {
            this.lFj.setText(R.string.relate_forum_is_followed);
            ao.setViewTextColor(this.lFj, R.color.CAM_X0109, 1);
            this.lFj.setEnabled(false);
            return;
        }
        this.lFj.setText(R.string.attention);
        this.lFj.setEnabled(true);
        ao.setViewTextColor(this.lFj, R.color.CAM_X0111, 1);
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
            if (d.this.lFf != null) {
                d.this.lFf.Pw(this.forumName);
            }
        }
    }
}
