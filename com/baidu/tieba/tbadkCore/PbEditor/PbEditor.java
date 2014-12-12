package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern bUu = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern bUx = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean YZ;
    private boolean bUc;
    private int bUp;
    private ak bUq;
    protected PbEditorToolView bUr;
    public EditorToolComponetContainer bUs;
    protected com.baidu.tbadk.editortool.w bUt;
    private boolean bUv;
    protected boolean bUw;
    protected Context mContext;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.YZ = z;
        if (this.bUs != null) {
            this.bUs.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.bUs;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.bUr;
    }

    public PbEditor(Context context) {
        super(context);
        this.bUp = 1000;
        this.bUc = false;
        this.YZ = false;
        this.bUw = true;
        this.mContext = context;
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUp = 1000;
        this.bUc = false;
        this.YZ = false;
        this.bUw = true;
        this.mContext = context;
        initialize();
    }

    public void setFrom(int i) {
        if (this.bUs != null) {
            this.bUs.setFrom(i);
        }
    }

    public void afB() {
        this.bUr.afB();
    }

    public void afC() {
        this.bUr.afC();
    }

    public boolean afD() {
        Editable text = this.bUr.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.bUs.afs() || this.bUs.aft()) {
            return true;
        }
        return this.bUs.afu();
    }

    public EditText getEditText() {
        return this.bUr.getEditText();
    }

    public void z(ArrayList<String> arrayList) {
        this.bUr.O(arrayList);
    }

    public String getContent() {
        return this.bUr.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.bUr.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.bUr.getEditText().setSelection(str.length());
        }
    }

    public void afE() {
        this.bUr.getEditText().requestFocus();
        this.bUs.V(this.bUr.getEditText());
    }

    public void afF() {
        this.bUs.hideAll();
        this.bUr.aeS();
    }

    public void afG() {
        this.bUs.hideAll();
        this.bUr.aeS();
    }

    public void afH() {
        if (this.bUs.afj() && !this.bUv) {
            this.bUv = true;
            ay.a(this, this.mContext, new aa(this));
            return;
        }
        afF();
    }

    public boolean afj() {
        return this.bUs.afj();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.pb_editor_view, this, true);
        this.bUr = (PbEditorToolView) findViewById(com.baidu.tieba.w.pb_editor_tool_button);
        this.bUs = (EditorToolComponetContainer) findViewById(com.baidu.tieba.w.pb_editor_tool_group);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void afI() {
        this.bUq = new ak(this.mContext);
        this.bUq.qA();
        addView(this.bUq, 0);
        this.bUq.setOnActionListener(this.bUt);
    }

    public boolean afx() {
        return this.bUs.afx();
    }

    public void T(View view) {
        this.bUs.T(view);
    }

    public void U(View view) {
        this.bUs.U(view);
    }

    public void Zz() {
        this.bUr.getEditText().requestFocus();
        this.bUs.V(this.bUr.getEditText());
        this.bUr.getEditText().setSelection(this.bUr.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ba baVar) {
        this.bUr.getEditText().requestFocus();
        this.bUs.U(this.bUr.getEditText());
        hG(i);
    }

    public void B(int i, String str) {
        if (this.bUq != null) {
            this.bUq.B(i, str);
            if (i == 2 && this.bUq.getVisibility() == 0) {
                this.bUs.vl();
                this.bUr.afP();
                return;
            }
            afJ();
        }
    }

    private void afJ() {
        if (this.bUs != null) {
            this.bUs.vm();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        B(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.bUq == null) {
            return 8;
        }
        return this.bUq.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.bUq == null) {
            return 0;
        }
        return this.bUq.getLocationInfoViewState();
    }

    protected void hG(int i) {
        if (i == 5) {
            this.bUs.afo();
        } else if (i == 23 || i == 22) {
            this.bUs.afp();
        } else if (i == 2) {
            this.bUs.afn();
        } else if (i == 38) {
            this.bUs.afm();
        } else if (i == 44) {
            this.bUs.afq();
        } else if (i == 50 || i == 48) {
            this.bUs.afr();
        }
    }

    public void hH(int i) {
        if (this.bUs.afj()) {
            hG(i);
            this.bUs.U(this.bUr.getEditText());
            return;
        }
        this.bUw = false;
        if (this.bUs.afx()) {
            this.bUs.U(this.bUr.getEditText());
        }
        new Handler().postDelayed(new ab(this, i), 200L);
    }

    public boolean Fl() {
        Editable text = this.bUr.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.bUp;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.w wVar) {
        this.mPageContext = tbPageContext;
        if (wVar != null) {
            this.bUt = wVar;
            if (this.bUq != null) {
                this.bUq.setOnActionListener(wVar);
            }
            this.bUr.setOnActionListener(new ad(this, wVar));
            this.bUs.setOnActionListener(new ae(this, wVar));
        }
    }

    public void afv() {
        this.bUs.afv();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().h(this.bUr);
            tbPageContext.getLayoutMode().h(this.bUs);
        }
        if (this.bUq != null) {
            this.bUq.qA();
        }
        this.bUr.changeSkinType(i);
        this.bUs.onChangeSkinType(i);
    }

    public void clearData() {
        this.bUr.clearData();
        this.bUs.clearData();
    }

    public void afl() {
        this.bUs.afl();
    }

    public void yB() {
        if (this.bUt != null) {
            this.bUt.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.bUt != null) {
            this.bUt.handleAction(34, null);
        }
        this.bUr.aeS();
        this.bUs.hideAll();
        U(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.bUr.setMoreFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.bUr.setAudioFocusable(z);
    }

    public void Yo() {
        this.bUr.Yo();
    }

    public void Yp() {
        this.bUr.Yp();
    }

    public void Fq() {
        this.bUs.Fq();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.bUs.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.bUs.setAudioData(voiceModel);
    }

    public void Fp() {
        this.bUs.Fp();
    }

    public void j(Bitmap bitmap) {
        this.bUs.setImage(bitmap);
    }

    public void aI(boolean z) {
        this.bUc = z;
        this.bUs.aI(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int ic(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = bUx.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.ab.vc().dU(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.bUc) {
            this.bUr.afQ();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble()) && !this.bUc) {
            if (!this.bUs.afs() && !this.bUs.aft() && !this.bUs.vk()) {
                this.bUr.afQ();
            } else {
                this.bUr.afP();
            }
        } else {
            this.bUr.afP();
        }
        this.bUs.refresh();
    }

    public void setMaxTextCount(int i) {
        this.bUp = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.bUq == null) {
                afI();
            }
            this.bUq.setVisibility(0);
            return;
        }
        if (this.bUq != null) {
            removeView(this.bUq);
            this.bUq = null;
        }
        afJ();
    }
}
