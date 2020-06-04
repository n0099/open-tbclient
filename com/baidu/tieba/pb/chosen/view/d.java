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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes10.dex */
public class d {
    private TextView dez;
    private View jEq;
    private b jEr;
    private TextView jEs;
    private BarImageView jEt;
    private TextView jEu;
    private TextView jEv;
    private LinearLayout jEw;
    private HeadImageView jcM;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void IZ(String str);

        void cCn();

        void eR(String str, String str2);
    }

    public d(Context context) {
        this.jEq = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.jEq.findViewById(R.id.chosen_pb_title);
        this.jcM = (HeadImageView) this.jEq.findViewById(R.id.chosen_pb_person_info_head);
        this.dez = (TextView) this.jEq.findViewById(R.id.chosen_pb_person_info_name);
        this.jEs = (TextView) this.jEq.findViewById(R.id.chosen_pb_bar_forum_name);
        this.jcM.setRadius(l.dip2px(context, 2.0f));
        this.jEt = (BarImageView) this.jEq.findViewById(R.id.chosen_pb_bar_pic);
        this.jEu = (TextView) this.jEq.findViewById(R.id.chosen_pb_bar_attention_number);
        this.jEv = (TextView) this.jEq.findViewById(R.id.chosen_pb_bar_attention_button);
        this.jEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jEr != null) {
                    d.this.jEr.cCn();
                }
            }
        });
        this.jEw = (LinearLayout) this.jEq.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cCq() {
        return this.jEq;
    }

    public void a(b bVar) {
        this.jEr = bVar;
    }

    public void Jb(String str) {
        if (!StringUtils.isNull(str) && this.jcM != null) {
            this.jcM.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.jEw.setVisibility(8);
                return;
            }
            k.aNQ().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.jEw.setVisibility(0);
            aL(context, excellentPbThreadInfo.forum.forum_name);
            if (this.jEt != null) {
                this.jEt.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.jEt.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.jEu != null && excellentPbThreadInfo.forum.member_count != null) {
                this.jEu.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                qY(true);
            } else {
                qY(false);
            }
        }
    }

    public void setName(String str) {
        if (this.dez != null) {
            this.dez.setText(str);
        }
    }

    private void aL(Context context, String str) {
        if (this.jEs != null) {
            if (StringUtils.isNull(str)) {
                this.jEs.setVisibility(4);
                return;
            }
            this.jEs.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.jEs.setOnClickListener(new a(str));
            this.jEs.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Jb(userInfo.portrait);
            this.jcM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.dez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, String str) {
        if (this.jEr != null) {
            this.jEr.eR(String.valueOf(j), str);
        }
    }

    public void qY(boolean z) {
        if (z) {
            this.jEv.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.jEv, R.color.cp_cont_d, 1);
            this.jEv.setEnabled(false);
            return;
        }
        this.jEv.setText(R.string.attention);
        this.jEv.setEnabled(true);
        am.setViewTextColor(this.jEv, R.color.cp_cont_g, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        public a(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.jEr != null) {
                d.this.jEr.IZ(this.forumName);
            }
        }
    }
}
