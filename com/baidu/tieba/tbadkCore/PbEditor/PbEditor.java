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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class PbEditor extends LinearLayout {
    private static final Pattern cqR = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private static final Pattern cqV = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private boolean ale;
    private int cqM;
    private ab cqN;
    protected PbEditorToolView cqO;
    public EditorToolComponetContainer cqP;
    protected com.baidu.tbadk.editortool.v cqQ;
    private boolean cqS;
    private final CustomMessageListener cqT;
    protected boolean cqU;
    private boolean cqx;
    protected Context mContext;
    private BdUniqueId mId;
    private TbPageContext<?> mPageContext;

    public void setHideBaobao(boolean z) {
        this.ale = z;
        if (this.cqP != null) {
            this.cqP.setHideBaobao(z);
        }
    }

    public EditorToolComponetContainer getEditorToolComponetContainer() {
        return this.cqP;
    }

    public PbEditorToolView getEditorToolButtonContainer() {
        return this.cqO;
    }

    public PbEditor(Context context) {
        super(context);
        this.cqM = 1000;
        this.cqx = false;
        this.ale = false;
        this.cqT = new q(this, 2001310);
        this.cqU = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public PbEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqM = 1000;
        this.cqx = false;
        this.ale = false;
        this.cqT = new q(this, 2001310);
        this.cqU = true;
        this.mContext = context;
        this.mId = BdUniqueId.gen();
        initialize();
    }

    public void setFrom(int i) {
        if (this.cqP != null) {
            this.cqP.setFrom(i);
        }
    }

    public void anP() {
        this.cqO.anP();
    }

    public void anQ() {
        this.cqO.anQ();
    }

    public boolean anR() {
        Editable text = this.cqO.getEditText().getText();
        if ((text != null && text.toString().trim().length() > 0) || this.cqP.anG() || this.cqP.anH()) {
            return true;
        }
        return this.cqP.anI();
    }

    public EditText getEditText() {
        return this.cqO.getEditText();
    }

    public void u(ArrayList<String> arrayList) {
        this.cqO.T(arrayList);
    }

    public String getContent() {
        return this.cqO.getEditText().getText().toString();
    }

    public void setContent(String str) {
        this.cqO.getEditText().setText(str);
        if (!TextUtils.isEmpty(str)) {
            this.cqO.getEditText().setSelection(str.length());
        }
    }

    public void anS() {
        this.cqO.getEditText().requestFocus();
        this.cqP.ab(this.cqO.getEditText());
    }

    public void anT() {
        this.cqP.hideAll();
        this.cqO.anf();
    }

    public void anU() {
        this.cqP.hideAll();
        this.cqO.anf();
    }

    public void anV() {
        if (this.cqP.anx() && !this.cqS) {
            this.cqS = true;
            ac.a(this, this.mContext, new r(this));
            return;
        }
        anT();
    }

    public boolean anx() {
        return this.cqP.anx();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_editor_view, this, true);
        this.cqO = (PbEditorToolView) findViewById(com.baidu.tieba.q.pb_editor_tool_button);
        this.cqP = (EditorToolComponetContainer) findViewById(com.baidu.tieba.q.pb_editor_tool_group);
        anW();
        MessageManager.getInstance().unRegisterListener(this.mId);
        this.cqT.setTag(this.mId);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.cqT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.cqT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anW() {
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(2802001)) {
            setHideBaobao(true);
        }
    }

    private void anX() {
        this.cqN = new ab(this.mContext);
        this.cqN.uy();
        addView(this.cqN, 0);
        this.cqN.setOnActionListener(this.cqQ);
    }

    public boolean anL() {
        return this.cqP.anL();
    }

    public void Z(View view) {
        this.cqP.Z(view);
    }

    public void aa(View view) {
        this.cqP.aa(view);
    }

    public void add() {
        this.cqO.getEditText().requestFocus();
        this.cqP.ab(this.cqO.getEditText());
        this.cqO.getEditText().setSelection(this.cqO.getEditText().getText().length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, ae aeVar) {
        this.cqO.getEditText().requestFocus();
        this.cqP.aa(this.cqO.getEditText());
        iM(i);
    }

    public void D(int i, String str) {
        if (this.cqN != null) {
            this.cqN.D(i, str);
            if (i == 2 && this.cqN.getVisibility() == 0) {
                this.cqP.zO();
                this.cqO.aoe();
                return;
            }
            anY();
        }
    }

    private void anY() {
        if (this.cqP != null) {
            this.cqP.zP();
            refresh();
        }
    }

    public void setLocationInfoViewState(int i) {
        D(i, null);
    }

    public int getLocationViewVisibility() {
        if (this.cqN == null) {
            return 8;
        }
        return this.cqN.getVisibility();
    }

    public int getLocationInfoViewState() {
        if (this.cqN == null) {
            return 0;
        }
        return this.cqN.getLocationInfoViewState();
    }

    protected void iM(int i) {
        if (i == 5) {
            this.cqP.anC();
        } else if (i == 23 || i == 22) {
            this.cqP.anD();
        } else if (i == 2) {
            this.cqP.anB();
        } else if (i == 38) {
            this.cqP.anA();
        } else if (i == 44) {
            this.cqP.anE();
        } else if (i == 50 || i == 48) {
            this.cqP.anF();
        }
    }

    public void iN(int i) {
        if (this.cqP.anx()) {
            iM(i);
            this.cqP.aa(this.cqO.getEditText());
            return;
        }
        this.cqU = false;
        if (this.cqP.anL()) {
            this.cqP.aa(this.cqO.getEditText());
        }
        new Handler().postDelayed(new s(this, i), 200L);
    }

    public boolean Kn() {
        Editable text = this.cqO.getEditText().getText();
        return (text == null ? 0 : text.length()) >= this.cqM;
    }

    public void a(TbPageContext<?> tbPageContext, com.baidu.tbadk.editortool.v vVar) {
        this.mPageContext = tbPageContext;
        if (vVar != null) {
            this.cqQ = vVar;
            if (this.cqN != null) {
                this.cqN.setOnActionListener(vVar);
            }
            this.cqO.setOnActionListener(new u(this, vVar));
            this.cqP.setOnActionListener(new v(this, vVar));
        }
    }

    public void anJ() {
        this.cqP.anJ();
    }

    public void b(TbPageContext<?> tbPageContext, int i) {
        this.mPageContext = tbPageContext;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().ab(i == 1);
            tbPageContext.getLayoutMode().j(this.cqO);
            tbPageContext.getLayoutMode().j(this.cqP);
        }
        if (this.cqN != null) {
            this.cqN.uy();
        }
        this.cqO.changeSkinType(i);
        this.cqP.onChangeSkinType(i);
    }

    public void clearData() {
        this.cqO.clearData();
        this.cqP.clearData();
    }

    public void anz() {
        this.cqP.anz();
    }

    public void CR() {
        if (this.cqQ != null) {
            this.cqQ.handleAction(33, null);
        }
        setVisibility(0);
    }

    public void hide() {
        if (this.cqQ != null) {
            this.cqQ.handleAction(34, null);
        }
        this.cqO.anf();
        this.cqP.hideAll();
        aa(getEditText());
        setVisibility(8);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void setMoreFocusable(boolean z) {
        this.cqO.setMoreFocusable(z);
    }

    public void acl() {
        if (this.cqP.cqg != null) {
            this.cqP.cqg.setHasAudio(false);
        }
    }

    public void acm() {
        if (this.cqP.cqg != null) {
            this.cqP.cqg.setHasAudio(true);
        }
    }

    public void Ks() {
        this.cqP.Ks();
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.cqP.getAudioData();
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        this.cqP.setAudioData(voiceModel);
    }

    public void Kr() {
        this.cqP.Kr();
    }

    public void aca() {
        this.cqP.zS();
    }

    public void k(Bitmap bitmap) {
        this.cqP.setImage(bitmap);
    }

    public void aX(boolean z) {
        this.cqx = z;
        this.cqP.aX(z);
        if (z) {
            setLocationViewVisibility(8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public static int jz(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = cqV.matcher(str);
            while (matcher.find()) {
                if (com.baidu.tbadk.editortool.aa.zF().ex(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void refresh() {
        if (this.cqx) {
            this.cqO.aof();
            return;
        }
        if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cqx) {
            if (!this.cqP.anG() && !this.cqP.anH() && !this.cqP.zN()) {
                this.cqO.aof();
            } else {
                this.cqO.aoe();
            }
        } else {
            this.cqO.aoe();
        }
        this.cqP.refresh();
    }

    public void setMaxTextCount(int i) {
        this.cqM = i;
    }

    public void setLocationViewVisibility(int i) {
        if (i == 0) {
            if (this.cqN == null) {
                anX();
            }
            this.cqN.setVisibility(0);
            return;
        }
        if (this.cqN != null) {
            removeView(this.cqN);
            this.cqN = null;
        }
        anY();
    }
}
