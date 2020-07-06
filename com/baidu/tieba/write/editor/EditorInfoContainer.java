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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes2.dex */
public class EditorInfoContainer extends RelativeLayout implements m {
    private EditorTools ZX;
    private int ZY;
    private boolean hHH;
    private String ici;
    private String mForumId;
    private String mFrom;
    private LocationInfoView mos;
    private TBSpecificationBtn mot;
    private TBSpecificationBtn mou;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void onChange(boolean z);
    }

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHH = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.tbds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.tbds117)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.ici = str;
        fw(context);
        fx(context);
        fy(context);
    }

    public void fA(long j) {
        int left = this.mos.getLeft();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mos, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mou, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((c) EditorInfoContainer.this.mou.getStyleConfig()).mC(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mou.getStyleConfig().mz(R.color.cp_link_tip_a);
                ((c) EditorInfoContainer.this.mos.getLocationBtn().getStyleConfig()).mC(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mos.getLocationBtn().getStyleConfig().mz(R.color.cp_link_tip_a);
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
                            ((c) EditorInfoContainer.this.mou.getStyleConfig()).mE(R.color.cp_cont_b);
                            EditorInfoContainer.this.mou.getStyleConfig().mz(R.color.cp_cont_e);
                            ((c) EditorInfoContainer.this.mos.getLocationBtn().getStyleConfig()).mE(R.color.cp_cont_b);
                            EditorInfoContainer.this.mos.getLocationBtn().getStyleConfig().mz(R.color.cp_cont_e);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        new com.baidu.tbadk.core.dialog.a(baseActivity).we(context.getString(R.string.write_privacy_dialog_title)).a(context.getString(R.string.write_privacy_dialog_open), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new ao("c13805").ag("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        }).b(context.getString(R.string.write_privacy_dialog_close), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new ao("c13805").ag("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        }).kV(R.color.cp_cont_b).kU(R.color.cp_link_tip_a).b(baseActivity.getPageContext()).aUN();
        TiebaStatic.log(new ao("c13804"));
    }

    private void fw(Context context) {
        this.mos = new LocationInfoView(context);
        this.mos.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.tbds31);
        this.mos.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void bfn() {
                TiebaStatic.log(new ao("c12612").ag("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.mos, layoutParams);
    }

    private void fx(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(1, R.id.editor_id_location);
        c cVar = new c();
        cVar.mE(R.color.cp_cont_b);
        cVar.mz(R.color.cp_cont_e);
        cVar.aR(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        cVar.k(R.drawable.ic_icon_pure_post_topic16_svg, 0, true);
        this.mou = new TBSpecificationBtn(context);
        this.mou.setConfig(cVar);
        this.mou.setTextSize(R.dimen.tbds32);
        this.mou.setText(getContext().getString(R.string.add_topic));
        this.mou.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.mou, layoutParams);
    }

    private void fy(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(11);
        c cVar = new c();
        cVar.mE(R.color.cp_cont_b);
        cVar.mz(R.color.cp_cont_e);
        cVar.aR(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.mot = new TBSpecificationBtn(context);
        this.mot.setConfig(cVar);
        this.mot.setTextSize(R.dimen.tbds32);
        GJ(0);
        this.mot.setLayoutParams(layoutParams);
        this.mot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ao("c12612").ag("obj_locate", ((Integer) EditorInfoContainer.this.mot.ege).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.mot.ege).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.ici)) {
                                TiebaStatic.log(new ao("c12608").ag("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.ici)) {
                                TiebaStatic.log(new ao("c12608").ag("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.mot.ege).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.GJ(i);
                            if ("2".equals(EditorInfoContainer.this.ici)) {
                                com.baidu.tieba.write.editor.a.bK(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.mot);
    }

    public boolean isPrivacy() {
        if (this.mot == null || ((Integer) this.mot.ege).intValue() != 0) {
            return this.mot != null && ((Integer) this.mot.ege).intValue() == 1;
        }
        return false;
    }

    public void bSl() {
    }

    public void drB() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bJ(String str, int i) {
        if ("2".equals(this.ici)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0769a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0769a
                public void GK(int i2) {
                    EditorInfoContainer.this.GJ(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ(int i) {
        this.mot.setText(i == 0 ? getResources().getString(R.string.public_to_all) : getResources().getString(R.string.public_to_me));
        this.mot.getStyleConfig().k(i == 0 ? R.drawable.ic_icon_pure_post_open16_svg : R.drawable.ic_icon_pure_post_hide16_svg, 0, true);
        this.mot.ege = Integer.valueOf(i);
    }

    public void vN(boolean z) {
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
                if (this.mos != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.mos.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.mos.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.mos != null) {
                    this.mos.setState(0, null);
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

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.hHH) {
            this.hHH = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        bSl();
        setVisibility(8);
    }

    public void vO(boolean z) {
        if (this.mou != null) {
            this.mou.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        if (this.mos != null) {
            this.mos.onChangeSkinType(i);
        }
        if (this.mot != null) {
            this.mot.aYj();
        }
        if (this.mou != null) {
            this.mou.aYj();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }
}
