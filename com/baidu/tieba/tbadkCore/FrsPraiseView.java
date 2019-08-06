package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FrsPraiseView extends LinearLayout {
    private View bmR;
    private boolean icb;
    private TextView jes;
    private TextView jet;
    private TextView jeu;
    private PraiseData jev;
    private boolean jew;
    private Context mContext;
    private String mPostId;
    private String mThreadId;

    public FrsPraiseView(Context context) {
        super(context, null);
        this.icb = false;
        this.jew = false;
    }

    public FrsPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.icb = false;
        this.jew = false;
        setOrientation(0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bmR = View.inflate(this.mContext, R.layout.frs_item_praise, this);
        this.jes = (TextView) this.bmR.findViewById(R.id.frs_go_praise_list_num);
        this.jet = (TextView) this.bmR.findViewById(R.id.frs_praise_user_name_text1);
        this.jeu = (TextView) this.bmR.findViewById(R.id.frs_praise_user_name_text2);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = "";
                if (FrsPraiseView.this.jev != null) {
                    str = FrsPraiseView.this.jev.getTitle();
                }
                com.baidu.tbadk.util.r.a(new PraiseListActivityConfig(FrsPraiseView.this.mContext, FrsPraiseView.this.mThreadId, FrsPraiseView.this.mPostId, str, FrsPraiseView.this.icb));
            }
        });
        this.jeu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jev.getUser().get(1);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
        this.jet.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.FrsPraiseView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MetaData metaData = FrsPraiseView.this.jev.getUser().get(0);
                if (metaData != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(FrsPraiseView.this.mContext).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
                }
            }
        });
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        if (praiseData != null) {
            this.mThreadId = str;
            this.mPostId = str2;
            this.jev = praiseData;
            qX(z);
        }
    }

    public void setIsFromPb(boolean z) {
        this.icb = z;
    }

    public void setIsFromPbVideo(boolean z) {
        this.jew = z;
    }

    private void qX(boolean z) {
        long num = this.jev.getNum();
        this.jeu.setVisibility(8);
        this.jet.setVisibility(8);
        if (num > 0) {
            ArrayList<MetaData> user = this.jev.getUser();
            if (user != null && user.size() > 0) {
                if (user.size() == 1) {
                    if (user.get(0) != null) {
                        this.jet.setVisibility(0);
                        this.jet.setText(Ez(user.get(0).getName_show()));
                    }
                } else {
                    if (user.get(0) != null) {
                        this.jet.setVisibility(0);
                        this.jet.setText(Ez(user.get(0).getName_show()));
                    }
                    if (user.get(1) != null) {
                        this.jeu.setVisibility(0);
                        this.jeu.setText("、" + Ez(user.get(1).getName_show()));
                    }
                }
            }
            if (num <= 2) {
                this.jes.setText(this.mContext.getString(R.string.common_praise_view_text));
            } else if (num <= 999999) {
                this.jes.setText(this.mContext.getString(R.string.etc) + num + this.mContext.getString(R.string.common_praise_view_text2));
            } else {
                this.jes.setText(this.mContext.getString(R.string.etc) + "999999+" + this.mContext.getString(R.string.common_praise_view_text2));
            }
        }
    }

    private String Ez(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 14) {
            return str.substring(0, 14);
        }
        return str;
    }

    public void jd(int i) {
        if (this.icb) {
            if (this.jew) {
                am.k(this.bmR, R.drawable.praise_video_selector);
                am.f(this.jes, R.color.cp_cont_c, 1);
                am.f(this.jet, R.color.cp_link_tip_c, 1);
                am.f(this.jeu, R.color.cp_link_tip_c, 1);
                return;
            }
            am.k(this.bmR, R.drawable.praise_head_selector);
            am.f(this.jes, R.color.cp_cont_d, 1);
            am.f(this.jet, R.color.cp_link_tip_c, 1);
            am.f(this.jeu, R.color.cp_link_tip_c, 1);
            return;
        }
        am.k(this.bmR, R.drawable.praise_view_btn_color);
        am.f(this.jes, R.color.cp_cont_d, 1);
        am.f(this.jet, R.color.cp_cont_c, 1);
        am.f(this.jeu, R.color.cp_cont_c, 1);
    }
}
