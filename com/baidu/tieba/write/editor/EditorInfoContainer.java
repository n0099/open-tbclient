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
import com.baidu.tbadk.core.util.e.c;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes13.dex */
public class EditorInfoContainer extends RelativeLayout implements m {
    private EditorTools FO;
    private int FP;
    private String gNY;
    private boolean gvI;
    private LocationInfoWithDelView kOf;
    private StateSwitchView kOg;
    private StateSwitchView kOh;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvI = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.gNY = str;
        fG(context);
        fH(context);
    }

    private void fG(Context context) {
        this.kOf = new LocationInfoWithDelView(context);
        this.kOf.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        this.kOf.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cUN() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cUO() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.kOf.hide();
            }
        });
        addView(this.kOf, layoutParams);
    }

    private void fH(Context context) {
        this.kOh = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.kOh.setLayoutParams(layoutParams);
        this.kOh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.gNY)) {
                        TiebaStatic.log(new an("c12608").X("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.gNY)) {
                        TiebaStatic.log(new an("c12608").X("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.kOh.baC();
                if ("2".equals(EditorInfoContainer.this.gNY)) {
                    a.bA(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.kOh.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.gNY)) {
            this.kOh.setStateString(getResources().getString(R.string.public_to_all), getResources().getString(R.string.public_to_me));
        } else if ("2".equals(this.gNY)) {
            this.kOh.setStateString(getResources().getString(R.string.display_on_my_home_page), getResources().getString(R.string.display_on_my_home_page));
            this.kOh.setLeftStateDrawable(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_stroke1_blue_h_svg), new c(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
            this.kOh.setPadding(this.kOh.getPaddingLeft(), 0, 0, 0);
            this.kOh.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds28));
        }
        addView(this.kOh);
    }

    public boolean isPrivacy() {
        return (this.kOh == null || this.kOh.getState() != 0) && this.kOh != null && this.kOh.getState() == 1;
    }

    public boolean isToDynamic() {
        return this.kOg != null && this.kOg.getState() == 0;
    }

    public void byJ() {
        if (this.kOh != null) {
            this.kOh.hideTip();
        }
    }

    public void cUM() {
        if (this.kOg != null) {
            this.kOg.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bz(String str, int i) {
        if ("2".equals(this.gNY)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0631a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0631a
                public void Eh(int i2) {
                    EditorInfoContainer.this.kOh.setState(i2 != 1 ? 0 : 1);
                }
            });
        }
    }

    public void tO(boolean z) {
        if (this.kOg != null) {
            this.kOg.setState(z ? 0 : 1);
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
                if (this.kOf != null && aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.isShow) {
                        this.kOf.setState(aVar2.state, aVar2.addr);
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
                    this.kOf.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 20:
                if (this.kOf != null) {
                    this.kOf.hide();
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
        if (this.gvI) {
            this.gvI = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        byJ();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        if (this.kOg != null) {
            this.kOg.onChangeSkinType(i);
        }
        if (this.kOf != null) {
            this.kOf.onChangeSkinType(i);
        }
        if (this.kOh != null) {
            this.kOh.onChangeSkinType(i);
            if ("1".equals(this.gNY)) {
                am.c(this.kOh, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }
}
