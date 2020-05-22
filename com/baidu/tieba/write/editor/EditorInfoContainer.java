package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.d.c;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes2.dex */
public class EditorInfoContainer extends RelativeLayout implements m {
    private EditorTools Zt;
    private int Zu;
    private String hOj;
    private boolean huG;
    private LocationInfoWithDelView lSM;
    private StateSwitchView lSN;
    private StateSwitchView lSO;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huG = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hOj = str;
        fw(context);
        fx(context);
    }

    private void fw(Context context) {
        this.lSM = new LocationInfoWithDelView(context);
        this.lSM.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        this.lSM.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void dmT() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void dmU() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.lSM.hide();
            }
        });
        addView(this.lSM, layoutParams);
    }

    private void fx(Context context) {
        this.lSO = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.lSO.setLayoutParams(layoutParams);
        this.lSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.hOj)) {
                        TiebaStatic.log(new an("c12608").ag("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.hOj)) {
                        TiebaStatic.log(new an("c12608").ag("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.lSO.aJZ();
                if ("2".equals(EditorInfoContainer.this.hOj)) {
                    a.bL(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.lSO.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hOj)) {
            this.lSO.setStateString(getResources().getString(R.string.public_to_all), getResources().getString(R.string.public_to_me));
        } else if ("2".equals(this.hOj)) {
            this.lSO.setStateString(getResources().getString(R.string.display_on_my_home_page), getResources().getString(R.string.display_on_my_home_page));
            this.lSO.setLeftStateDrawable(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_stroke1_blue_h_svg), new c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
            this.lSO.setPadding(this.lSO.getPaddingLeft(), 0, 0, 0);
            this.lSO.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds28));
        }
        addView(this.lSO);
    }

    public boolean isPrivacy() {
        return (this.lSO == null || this.lSO.getState() != 0) && this.lSO != null && this.lSO.getState() == 1;
    }

    public boolean isToDynamic() {
        return this.lSN != null && this.lSN.getState() == 0;
    }

    public void bPf() {
        if (this.lSO != null) {
            this.lSO.hideTip();
        }
    }

    public void dmS() {
        if (this.lSN != null) {
            this.lSN.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bK(String str, int i) {
        if ("2".equals(this.hOj)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0751a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0751a
                public void FD(int i2) {
                    EditorInfoContainer.this.lSO.setState(i2 != 1 ? 0 : 1);
                }
            });
        }
    }

    public void vt(boolean z) {
        if (this.lSN != null) {
            this.lSN.setState(z ? 0 : 1);
        }
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
                if (this.lSM != null && aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.isShow) {
                        this.lSM.setState(aVar2.state, aVar2.addr);
                        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                            if (!StringUtils.isNull(aVar2.addr)) {
                                setVisibility(0);
                                return;
                            } else {
                                setVisibility(8);
                                return;
                            }
                        }
                        return;
                    }
                    this.lSM.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 20:
                if (this.lSM != null) {
                    this.lSM.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
            case 57:
                b(new com.baidu.tbadk.editortools.a(58, -1, Boolean.valueOf(isToDynamic())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.huG) {
            this.huG = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        bPf();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        if (this.lSN != null) {
            this.lSN.onChangeSkinType(i);
        }
        if (this.lSM != null) {
            this.lSM.onChangeSkinType(i);
        }
        if (this.lSO != null) {
            this.lSO.onChangeSkinType(i);
            if ("1".equals(this.hOj)) {
                am.c(this.lSO, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }
}
