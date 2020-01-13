package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes8.dex */
public class d {
    private TextView cqf;
    private HeadImageView hZn;
    private View iyV;
    private b iyW;
    private TextView iyX;
    private BarImageView iyY;
    private TextView iyZ;
    private TextView iza;
    private LinearLayout izb;
    private TextView title;

    /* loaded from: classes8.dex */
    public interface b {
        void Fp(String str);

        void ciD();

        void dU(String str, String str2);
    }

    public d(Context context) {
        this.iyV = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.iyV.findViewById(R.id.chosen_pb_title);
        this.hZn = (HeadImageView) this.iyV.findViewById(R.id.chosen_pb_person_info_head);
        this.cqf = (TextView) this.iyV.findViewById(R.id.chosen_pb_person_info_name);
        this.iyX = (TextView) this.iyV.findViewById(R.id.chosen_pb_bar_forum_name);
        this.hZn.setRadius(l.dip2px(context, 2.0f));
        this.iyY = (BarImageView) this.iyV.findViewById(R.id.chosen_pb_bar_pic);
        this.iyZ = (TextView) this.iyV.findViewById(R.id.chosen_pb_bar_attention_number);
        this.iza = (TextView) this.iyV.findViewById(R.id.chosen_pb_bar_attention_button);
        this.iza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iyW != null) {
                    d.this.iyW.ciD();
                }
            }
        });
        this.izb = (LinearLayout) this.iyV.findViewById(R.id.chosen_pb_bar_container);
    }

    public View ciG() {
        return this.iyV;
    }

    public void a(b bVar) {
        this.iyW = bVar;
    }

    public void Fr(String str) {
        if (!StringUtils.isNull(str) && this.hZn != null) {
            this.hZn.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.izb.setVisibility(8);
                return;
            }
            i.axy().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.izb.setVisibility(0);
            bb(context, excellentPbThreadInfo.forum.forum_name);
            if (this.iyY != null) {
                this.iyY.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.iyY.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.iyZ != null && excellentPbThreadInfo.forum.member_count != null) {
                this.iyZ.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                po(true);
            } else {
                po(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cqf != null) {
            this.cqf.setText(str);
        }
    }

    private void bb(Context context, String str) {
        if (this.iyX != null) {
            if (StringUtils.isNull(str)) {
                this.iyX.setVisibility(4);
                return;
            }
            this.iyX.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.iyX.setOnClickListener(new a(str));
            this.iyX.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Fr(userInfo.portrait);
            this.hZn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.s(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j, String str) {
        if (this.iyW != null) {
            this.iyW.dU(String.valueOf(j), str);
        }
    }

    public void po(boolean z) {
        if (z) {
            this.iza.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.iza, R.color.cp_cont_d, 1);
            this.iza.setEnabled(false);
            return;
        }
        this.iza.setText(R.string.attention);
        this.iza.setEnabled(true);
        am.setViewTextColor(this.iza, R.color.cp_cont_g, 1);
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
            if (d.this.iyW != null) {
                d.this.iyW.Fp(this.forumName);
            }
        }
    }
}
