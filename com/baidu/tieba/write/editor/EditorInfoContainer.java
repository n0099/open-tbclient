package com.baidu.tieba.write.editor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.a;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements n {
    private EditorTools abp;
    private int abq;
    private boolean iRa;
    private String jlN;
    private String mForumId;
    private String mFrom;
    private LocationInfoView nIp;
    private TBSpecificationBtn nIq;
    private TBSpecificationBtn nIr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void onChange(boolean z);
    }

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iRa = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        this.jlN = str;
        fZ(context);
        ga(context);
        gb(context);
    }

    public void hh(long j) {
        int left = this.nIp.getLeft() + 10;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nIp, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nIr, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nIr.getStyleConfig()).qG(R.color.CAM_X0302);
                EditorInfoContainer.this.nIr.getStyleConfig().qC(R.color.CAM_X0302);
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nIp.getLocationBtn().getStyleConfig()).qG(R.color.CAM_X0302);
                EditorInfoContainer.this.nIp.getLocationBtn().getStyleConfig().qC(R.color.CAM_X0302);
                animatorSet.start();
            }
        }, 1000L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            int count = 0;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.count++;
                if (this.count > 1) {
                    EditorInfoContainer.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nIr.getStyleConfig()).qI(R.color.CAM_X0105);
                            EditorInfoContainer.this.nIr.getStyleConfig().qC(R.color.CAM_X0110);
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nIp.getLocationBtn().getStyleConfig()).qI(R.color.CAM_X0105);
                            EditorInfoContainer.this.nIp.getLocationBtn().getStyleConfig().qC(R.color.CAM_X0110);
                        }
                    }, 0L);
                } else {
                    EditorInfoContainer.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            animatorSet.start();
                        }
                    }, 1500L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, final a aVar) {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(baseActivity);
        aVar2.iW(false);
        aVar2.a((String) null, (a.b) null);
        aVar2.b((String) null, (a.b) null);
        aVar2.ov(6);
        CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
        customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.write_privacy_dialog_title));
        customPrivacyDialogView.setMessageTextViewColor(ap.getColor(R.color.CAM_X0107));
        customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.write_privacy_dialog_close));
        customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.write_privacy_dialog_open));
        customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    TiebaStatic.log(new ar("c13805").ak("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        });
        customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    TiebaStatic.log(new ar("c13805").ak("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        });
        aVar2.bg(customPrivacyDialogView);
        aVar2.b(baseActivity.getPageContext()).bog();
        TiebaStatic.log(new ar("c13804"));
    }

    private void fZ(Context context) {
        this.nIp = new LocationInfoView(context);
        this.nIp.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.nIp.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void bze() {
                TiebaStatic.log(new ar("c12612").ak("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.nIp, layoutParams);
    }

    private void ga(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.addRule(1, R.id.editor_id_location);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.qC(R.color.CAM_X0110);
        bVar.qF(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.ba(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.qE(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.a(R.drawable.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.qB(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.nIr = new TBSpecificationBtn(context);
        this.nIr.setConfig(bVar);
        this.nIr.setTextSize(R.dimen.T_X09);
        this.nIr.setText(getContext().getString(R.string.add_topic));
        this.nIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.nIr, layoutParams);
    }

    private void gb(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.addRule(11);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.qC(R.color.CAM_X0302);
        bVar.qF(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.ba(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.qE(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.qB(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.nIq = new TBSpecificationBtn(context);
        this.nIq.setConfig(bVar);
        this.nIq.setTextSize(R.dimen.T_X09);
        LU(0);
        this.nIq.setLayoutParams(layoutParams);
        this.nIq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12612").ak("obj_locate", ((Integer) EditorInfoContainer.this.nIq.eYb).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.nIq.eYb).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.jlN)) {
                                TiebaStatic.log(new ar("c12608").ak("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.jlN)) {
                                TiebaStatic.log(new ar("c12608").ak("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.nIq.eYb).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.LU(i);
                            if ("2".equals(EditorInfoContainer.this.jlN)) {
                                com.baidu.tieba.write.editor.a.bQ(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.nIq);
    }

    public boolean isPrivacy() {
        if (this.nIq == null || ((Integer) this.nIq.eYb).intValue() != 0) {
            return this.nIq != null && ((Integer) this.nIq.eYb).intValue() == 1;
        }
        return false;
    }

    public void crO() {
    }

    public void dTG() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bP(String str, int i) {
        if ("2".equals(this.jlN)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0880a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0880a
                public void LV(int i2) {
                    EditorInfoContainer.this.LU(i2);
                }
            });
        }
    }

    public void LT(int i) {
        if ("2".equals(this.jlN)) {
            LU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LU(int i) {
        this.nIq.setText(getResources().getString(R.string.public_to_all));
        this.nIq.getStyleConfig().a(i == 0 ? R.drawable.icon_pure_post_chosen12 : R.drawable.icon_pure_post_chose12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.nIq.getStyleConfig().qC(i == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
        this.nIq.eYb = Integer.valueOf(i);
    }

    public void yF(boolean z) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar == null) {
            return;
        }
        switch (aVar.code) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 46:
            case 49:
            default:
                return;
            case 19:
                if (this.nIp != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.nIp.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.nIp.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.nIp != null) {
                    this.nIp.setState(0, null);
                    return;
                }
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
            case 57:
                b(new com.baidu.tbadk.editortools.a(58, -1, false));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.iRa) {
            this.iRa = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abq;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        crO();
        setVisibility(8);
    }

    public void yG(boolean z) {
        if (this.nIr != null) {
            this.nIr.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        if (this.nIp != null) {
            this.nIp.onChangeSkinType(i);
        }
        if (this.nIq != null) {
            this.nIq.brT();
        }
        if (this.nIr != null) {
            this.nIr.brT();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }
}
