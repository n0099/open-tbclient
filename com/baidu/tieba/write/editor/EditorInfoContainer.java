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
    private EditorTools acn;
    private int aco;
    private boolean jbU;
    private String jzs;
    private String mForumId;
    private String mFrom;
    private LocationInfoView nWx;
    private TBSpecificationBtn nWy;
    private TBSpecificationBtn nWz;

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
        this.jbU = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        this.jzs = str;
        gK(context);
        gL(context);
        gM(context);
    }

    public void hM(long j) {
        int left = this.nWx.getLeft() + 10;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nWx, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nWz, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nWz.getStyleConfig()).rh(R.color.CAM_X0302);
                EditorInfoContainer.this.nWz.getStyleConfig().rd(R.color.CAM_X0302);
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nWx.getLocationBtn().getStyleConfig()).rh(R.color.CAM_X0302);
                EditorInfoContainer.this.nWx.getLocationBtn().getStyleConfig().rd(R.color.CAM_X0302);
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
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nWz.getStyleConfig()).rj(R.color.CAM_X0105);
                            EditorInfoContainer.this.nWz.getStyleConfig().rd(R.color.CAM_X0110);
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nWx.getLocationBtn().getStyleConfig()).rj(R.color.CAM_X0105);
                            EditorInfoContainer.this.nWx.getLocationBtn().getStyleConfig().rd(R.color.CAM_X0110);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(baseActivity);
        aVar2.jl(false);
        aVar2.a((String) null, (a.b) null);
        aVar2.b((String) null, (a.b) null);
        aVar2.oT(6);
        CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
        customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.write_privacy_dialog_title));
        customPrivacyDialogView.setMessageTextViewColor(ap.getColor(R.color.CAM_X0107));
        customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.write_privacy_dialog_close));
        customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.write_privacy_dialog_open));
        customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    TiebaStatic.log(new ar("c13805").al("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        });
        customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    TiebaStatic.log(new ar("c13805").al("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        });
        aVar2.bi(customPrivacyDialogView);
        aVar2.b(baseActivity.getPageContext()).brv();
        TiebaStatic.log(new ar("c13804"));
    }

    private void gK(Context context) {
        this.nWx = new LocationInfoView(context);
        this.nWx.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.nWx.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void bCE() {
                TiebaStatic.log(new ar("c12612").al("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.nWx, layoutParams);
    }

    private void gL(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.addRule(1, R.id.editor_id_location);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.rd(R.color.CAM_X0110);
        bVar.rg(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.bc(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rf(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.a(R.drawable.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.nWz = new TBSpecificationBtn(context);
        this.nWz.setConfig(bVar);
        this.nWz.setTextSize(R.dimen.T_X09);
        this.nWz.setText(getContext().getString(R.string.add_topic));
        this.nWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.nWz, layoutParams);
    }

    private void gM(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.addRule(11);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.rd(R.color.CAM_X0302);
        bVar.rg(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.bc(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rf(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.nWy = new TBSpecificationBtn(context);
        this.nWy.setConfig(bVar);
        this.nWy.setTextSize(R.dimen.T_X09);
        MM(0);
        this.nWy.setLayoutParams(layoutParams);
        this.nWy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ar("c12612").al("obj_locate", ((Integer) EditorInfoContainer.this.nWy.ffy).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.nWy.ffy).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.jzs)) {
                                TiebaStatic.log(new ar("c12608").al("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.jzs)) {
                                TiebaStatic.log(new ar("c12608").al("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.nWy.ffy).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.MM(i);
                            if ("2".equals(EditorInfoContainer.this.jzs)) {
                                com.baidu.tieba.write.editor.a.bT(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.nWy);
    }

    public boolean isPrivacy() {
        if (this.nWy == null || ((Integer) this.nWy.ffy).intValue() != 0) {
            return this.nWy != null && ((Integer) this.nWy.ffy).intValue() == 1;
        }
        return false;
    }

    public void cwe() {
    }

    public void dZb() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bS(String str, int i) {
        if ("2".equals(this.jzs)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0896a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0896a
                public void MN(int i2) {
                    EditorInfoContainer.this.MM(i2);
                }
            });
        }
    }

    public void ML(int i) {
        if ("2".equals(this.jzs)) {
            MM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MM(int i) {
        this.nWy.setText(getResources().getString(R.string.public_to_all));
        this.nWy.getStyleConfig().a(i == 0 ? R.drawable.icon_pure_post_chosen12 : R.drawable.icon_pure_post_chose12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.nWy.getStyleConfig().rd(i == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
        this.nWy.ffy = Integer.valueOf(i);
    }

    public void zk(boolean z) {
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
                if (this.nWx != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.nWx.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.nWx.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.nWx != null) {
                    this.nWx.setState(0, null);
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
    public void su() {
        if (this.jbU) {
            this.jbU = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        cwe();
        setVisibility(8);
    }

    public void zl(boolean z) {
        if (this.nWz != null) {
            this.nWz.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        if (this.nWx != null) {
            this.nWx.onChangeSkinType(i);
        }
        if (this.nWy != null) {
            this.nWy.bvt();
        }
        if (this.nWz != null) {
            this.nWz.bvt();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }
}
