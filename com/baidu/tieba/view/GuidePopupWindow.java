package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.GuideScrollView;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class GuidePopupWindow extends Dialog {
    private TextView hBD;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView mxB;
    private HeadPendantView oaC;
    private ImageView oaD;
    private TextView oaE;
    private TextView oaF;
    private TextView oaG;
    private TextView oaH;
    private TextView oaI;
    private TextView oaJ;
    private TextView oaK;
    private TextView oaL;
    private TextView oaM;
    private TextView oaN;
    private RelativeLayout oaO;
    private RelativeLayout oaP;
    private RelativeLayout oaQ;
    private RelativeLayout oaR;
    private TBSpecificationBtn oaS;
    private TBSpecificationBtn oaT;
    private GuideScrollView oaU;
    private View oaV;
    private HeadBorder oaW;
    private ForegroundColorSpan oaX;
    private ForegroundColorSpan oaY;
    private boolean oaZ;
    private final String oba;
    private final String obb;
    private View.OnClickListener obc;
    private View.OnClickListener obd;
    private View.OnClickListener obe;
    private View.OnClickListener obf;
    private View.OnClickListener obg;
    private View.OnClickListener obh;
    private GuideScrollView.a obi;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.oba = "认证：";
        this.obb = "c13887";
        this.obc = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCL().bCN().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.aq("obj_locate", 1);
                TiebaStatic.log(arVar);
            }
        };
        this.obd = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCL().bCN().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.aq("obj_locate", 4);
                TiebaStatic.log(arVar);
            }
        };
        this.obe = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCL().bCN().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.aq("obj_locate", 3);
                TiebaStatic.log(arVar);
            }
        };
        this.obf = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCL().bCN().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.aq("obj_locate", 2);
                TiebaStatic.log(arVar);
            }
        };
        this.obg = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCL().bCN().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.aq("obj_locate", 6);
                TiebaStatic.log(arVar);
            }
        };
        this.obh = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCL().bCN().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.aq("obj_locate", 5);
                TiebaStatic.log(arVar);
            }
        };
        this.obi = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.oaV.setAlpha(GuidePopupWindow.this.oaU.getScrollY() / 150.0f);
            }
        };
        this.mContext = context;
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.guide_popup_window, (ViewGroup) null);
        this.mRootView.setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
        getWindow().setDimAmount(0.0f);
        initView();
        onChangeSkinType();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mRootView);
        getWindow().setLayout(-1, -1);
        com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
    }

    public void Vi(String str) {
        this.oaE.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void gc(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.oaZ = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            gd(list);
        }
    }

    public void O(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = au.ec(j).length();
        spannableStringBuilder.append((CharSequence) au.ec(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = au.ec(j2).length();
        spannableStringBuilder.append((CharSequence) au.ec(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.oaX, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.oaY, length + 14 + 8, length + 22 + length2, 18);
        this.oaF.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void Ai(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.oaX = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        this.oaY = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ap.setViewTextColor(this.hBD, R.color.CAM_X0101);
        ap.setViewTextColor(this.oaF, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ap.setViewTextColor(this.mxB, R.color.CAM_X0108);
        ap.setViewTextColor(this.oaG, R.color.CAM_X0101);
        ap.setViewTextColor(this.oaH, R.color.CAM_X0108);
        ap.setViewTextColor(this.oaI, R.color.CAM_X0101);
        ap.setViewTextColor(this.oaJ, R.color.CAM_X0108);
        ap.setViewTextColor(this.oaK, R.color.CAM_X0101);
        ap.setViewTextColor(this.oaL, R.color.CAM_X0108);
        ap.setViewTextColor(this.oaM, R.color.CAM_X0101);
        ap.setViewTextColor(this.oaN, R.color.CAM_X0108);
        ap.setViewTextColor(this.oaE, R.color.CAM_X0108);
        ap.setViewTextColor(this.oaT, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.b(this.oaS, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ap.b(this.oaT, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dWn() {
        if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
            this.hBD.setText(com.baidu.tbadk.getUserInfo.b.bCL().bCN().getName_show());
        }
    }

    public void dWo() {
        if (com.baidu.tbadk.getUserInfo.b.bCL() != null && com.baidu.tbadk.getUserInfo.b.bCL().bCN() != null) {
            this.oaC.a(com.baidu.tbadk.getUserInfo.b.bCL().bCN());
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.oaC.a(userData);
        }
    }

    public void Vj(String str) {
        this.oaD.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.oaU = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.oaU.setScrollChangedListener(this.obi);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.oaC = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.oaC.setHasPendantStyle();
        this.oaC.setDefalutResid(R.drawable.default_head);
        this.oaC.getHeadView().setIsRound(true);
        this.oaC.getHeadView().setDrawBorder(true);
        this.oaC.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.oaC.setShowSimpleIcon(true);
        this.oaD = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hBD = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.oaE = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.oaF = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mxB = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.oaO = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.oaG = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.oaH = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.oaP = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.oaI = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.oaJ = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.oaQ = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.oaK = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.oaL = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.oaR = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.oaM = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.oaN = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.oaS = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.oaS.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pS(R.color.CAM_X0302);
        this.oaS.setConfig(cVar);
        this.oaS.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.oaT = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pS(R.color.CAM_X0618);
        this.oaT.setConfig(cVar2);
        this.oaT.setTextSize(R.dimen.tbds42);
        this.oaT.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.oaV = this.mRootView.findViewById(R.id.shadow_top);
        this.oaV.setAlpha(0.0f);
        this.oaW = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.oaW.setBorderColor(ap.getColor(R.color.CAM_X0614));
        this.oaW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.oaW.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dWp();
    }

    private void dWp() {
        this.oaO.setOnClickListener(this.obc);
        this.oaP.setOnClickListener(this.obd);
        this.oaQ.setOnClickListener(this.obe);
        this.oaR.setOnClickListener(this.obf);
        this.oaS.setOnClickListener(this.obg);
        this.oaT.setOnClickListener(this.obh);
    }

    private void gd(final List<String> list) {
        this.oaE.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.oaE.setText(GuidePopupWindow.this.ge(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ge(List<String> list) {
        String a2 = a(list, 0, true);
        if (Vk(a2) >= this.oaE.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Vk(a3) < this.oaE.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Vk(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.oaE.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.oaE.getPaint().measureText(str) + 0.5f));
    }

    private String a(List<String> list, int i, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("认证：");
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str2 = list.get(i2);
            if (z) {
                str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
            } else if (str2.length() > i) {
                str = str2.substring(0, i - 1) + getContext().getResources().getString(R.string.guide_popup_window_join_field_bars_owner);
            } else {
                str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
            }
            sb.append(str + "    ");
        }
        if (this.oaZ) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int obm;
        private Paint paint;

        public HeadBorder(Context context) {
            this(context, null);
        }

        public HeadBorder(Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public HeadBorder(Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.STROKE);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.obm, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.obm = i;
        }
    }
}
