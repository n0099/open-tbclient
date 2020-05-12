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
/* loaded from: classes10.dex */
public class d {
    private TextView cTw;
    private HeadImageView iMY;
    private View jmO;
    private b jmP;
    private TextView jmQ;
    private BarImageView jmR;
    private TextView jmS;
    private TextView jmT;
    private LinearLayout jmU;
    private TextView title;

    /* loaded from: classes10.dex */
    public interface b {
        void Hp(String str);

        void cvh();

        void eq(String str, String str2);
    }

    public d(Context context) {
        this.jmO = LayoutInflater.from(context).inflate(R.layout.chosen_pb_person_info, (ViewGroup) null);
        this.title = (TextView) this.jmO.findViewById(R.id.chosen_pb_title);
        this.iMY = (HeadImageView) this.jmO.findViewById(R.id.chosen_pb_person_info_head);
        this.cTw = (TextView) this.jmO.findViewById(R.id.chosen_pb_person_info_name);
        this.jmQ = (TextView) this.jmO.findViewById(R.id.chosen_pb_bar_forum_name);
        this.iMY.setRadius(l.dip2px(context, 2.0f));
        this.jmR = (BarImageView) this.jmO.findViewById(R.id.chosen_pb_bar_pic);
        this.jmS = (TextView) this.jmO.findViewById(R.id.chosen_pb_bar_attention_number);
        this.jmT = (TextView) this.jmO.findViewById(R.id.chosen_pb_bar_attention_button);
        this.jmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jmP != null) {
                    d.this.jmP.cvh();
                }
            }
        });
        this.jmU = (LinearLayout) this.jmO.findViewById(R.id.chosen_pb_bar_container);
    }

    public View cvk() {
        return this.jmO;
    }

    public void a(b bVar) {
        this.jmP = bVar;
    }

    public void Hr(String str) {
        if (!StringUtils.isNull(str) && this.iMY != null) {
            this.iMY.startLoad(str, 12, false);
        }
    }

    public void a(Context context, ExcellentPbThreadInfo excellentPbThreadInfo) {
        if (excellentPbThreadInfo != null && this.title != null) {
            this.title.setText(excellentPbThreadInfo.title);
            if (StringUtils.isNull(excellentPbThreadInfo.forum.forum_name) || excellentPbThreadInfo.forum.forum_id == null || excellentPbThreadInfo.excid.longValue() <= 0) {
                this.jmU.setVisibility(8);
                return;
            }
            i.aIc().setForumNameForWaterImage(excellentPbThreadInfo.forum.forum_name);
            this.jmU.setVisibility(0);
            aK(context, excellentPbThreadInfo.forum.forum_name);
            if (this.jmR != null) {
                this.jmR.startLoad(excellentPbThreadInfo.forum.avatar, 16, false);
                this.jmR.setOnClickListener(new a(excellentPbThreadInfo.forum.forum_name));
            }
            if (this.jmS != null && excellentPbThreadInfo.forum.member_count != null) {
                this.jmS.setText(aq.numFormatOver10000(excellentPbThreadInfo.forum.member_count.intValue()));
            }
            if (excellentPbThreadInfo.forum.is_like != null && excellentPbThreadInfo.forum.is_like.intValue() == 1) {
                qB(true);
            } else {
                qB(false);
            }
        }
    }

    public void setName(String str) {
        if (this.cTw != null) {
            this.cTw.setText(str);
        }
    }

    private void aK(Context context, String str) {
        if (this.jmQ != null) {
            if (StringUtils.isNull(str)) {
                this.jmQ.setVisibility(4);
                return;
            }
            this.jmQ.setText(context.getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedText(str, 7, false)));
            this.jmQ.setOnClickListener(new a(str));
            this.jmQ.setVisibility(0);
        }
    }

    public void a(final UserInfo userInfo) {
        if (userInfo != null) {
            setName(userInfo.name);
            Hr(userInfo.portrait);
            this.iMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
            this.cTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.chosen.view.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.u(userInfo.id.longValue(), userInfo.name);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, String str) {
        if (this.jmP != null) {
            this.jmP.eq(String.valueOf(j), str);
        }
    }

    public void qB(boolean z) {
        if (z) {
            this.jmT.setText(R.string.relate_forum_is_followed);
            am.setViewTextColor(this.jmT, R.color.cp_cont_d, 1);
            this.jmT.setEnabled(false);
            return;
        }
        this.jmT.setText(R.string.attention);
        this.jmT.setEnabled(true);
        am.setViewTextColor(this.jmT, R.color.cp_cont_g, 1);
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
            if (d.this.jmP != null) {
                d.this.jmP.Hp(this.forumName);
            }
        }
    }
}
