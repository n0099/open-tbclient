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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements m {
    private EditorTools ZS;
    private int ZT;
    private boolean hNG;
    private String iik;
    private String mForumId;
    private String mFrom;
    private LocationInfoView mwr;
    private TBSpecificationBtn mws;
    private TBSpecificationBtn mwt;

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
        this.hNG = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.tbds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.tbds117)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.iik = str;
        fz(context);
        fA(context);
        fB(context);
    }

    public void fN(long j) {
        int left = this.mwr.getLeft();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mwr, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mwt, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((c) EditorInfoContainer.this.mwt.getStyleConfig()).mV(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mwt.getStyleConfig().mS(R.color.cp_link_tip_a);
                ((c) EditorInfoContainer.this.mwr.getLocationBtn().getStyleConfig()).mV(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mwr.getLocationBtn().getStyleConfig().mS(R.color.cp_link_tip_a);
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
                            ((c) EditorInfoContainer.this.mwt.getStyleConfig()).mX(R.color.cp_cont_b);
                            EditorInfoContainer.this.mwt.getStyleConfig().mS(R.color.cp_cont_e);
                            ((c) EditorInfoContainer.this.mwr.getLocationBtn().getStyleConfig()).mX(R.color.cp_cont_b);
                            EditorInfoContainer.this.mwr.getLocationBtn().getStyleConfig().mS(R.color.cp_cont_e);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        new com.baidu.tbadk.core.dialog.a(baseActivity).xl(context.getString(R.string.write_privacy_dialog_title)).a(context.getString(R.string.write_privacy_dialog_open), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new ap("c13805").ah("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        }).b(context.getString(R.string.write_privacy_dialog_close), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new ap("c13805").ah("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        }).lp(R.color.cp_cont_b).lo(R.color.cp_link_tip_a).b(baseActivity.getPageContext()).aYL();
        TiebaStatic.log(new ap("c13804"));
    }

    private void fz(Context context) {
        this.mwr = new LocationInfoView(context);
        this.mwr.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.tbds31);
        this.mwr.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void biX() {
                TiebaStatic.log(new ap("c12612").ah("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.mwr, layoutParams);
    }

    private void fA(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(1, R.id.editor_id_location);
        c cVar = new c();
        cVar.mX(R.color.cp_cont_b);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        cVar.k(R.drawable.ic_icon_pure_post_topic16_svg, 0, true);
        this.mwt = new TBSpecificationBtn(context);
        this.mwt.setConfig(cVar);
        this.mwt.setTextSize(R.dimen.tbds32);
        this.mwt.setText(getContext().getString(R.string.add_topic));
        this.mwt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.mwt, layoutParams);
    }

    private void fB(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(11);
        c cVar = new c();
        cVar.mX(R.color.cp_cont_b);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.mws = new TBSpecificationBtn(context);
        this.mws.setConfig(cVar);
        this.mws.setTextSize(R.dimen.tbds32);
        He(0);
        this.mws.setLayoutParams(layoutParams);
        this.mws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12612").ah("obj_locate", ((Integer) EditorInfoContainer.this.mws.emo).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.mws.emo).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.iik)) {
                                TiebaStatic.log(new ap("c12608").ah("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.iik)) {
                                TiebaStatic.log(new ap("c12608").ah("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.mws.emo).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.He(i);
                            if ("2".equals(EditorInfoContainer.this.iik)) {
                                com.baidu.tieba.write.editor.a.bI(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.mws);
    }

    public boolean isPrivacy() {
        if (this.mws == null || ((Integer) this.mws.emo).intValue() != 0) {
            return this.mws != null && ((Integer) this.mws.emo).intValue() == 1;
        }
        return false;
    }

    public void bVC() {
    }

    public void duN() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bH(String str, int i) {
        if ("2".equals(this.iik)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0779a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0779a
                public void Hf(int i2) {
                    EditorInfoContainer.this.He(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He(int i) {
        this.mws.setText(i == 0 ? getResources().getString(R.string.public_to_all) : getResources().getString(R.string.public_to_me));
        this.mws.getStyleConfig().k(i == 0 ? R.drawable.ic_icon_pure_post_open16_svg : R.drawable.ic_icon_pure_post_hide16_svg, 0, true);
        this.mws.emo = Integer.valueOf(i);
    }

    public void wr(boolean z) {
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
                if (this.mwr != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.mwr.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.mwr.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.mwr != null) {
                    this.mwr.setState(0, null);
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
        if (this.hNG) {
            this.hNG = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        bVC();
        setVisibility(8);
    }

    public void ws(boolean z) {
        if (this.mwt != null) {
            this.mwt.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        if (this.mwr != null) {
            this.mwr.onChangeSkinType(i);
        }
        if (this.mws != null) {
            this.mws.bci();
        }
        if (this.mwt != null) {
            this.mwt.bci();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }
}
