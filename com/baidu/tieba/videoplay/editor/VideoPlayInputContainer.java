package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools SY;
    private int SZ;
    private int aHp;
    private EditText aVV;
    private LinearLayout aVZ;
    private boolean aVt;
    private boolean aVu;
    private boolean aVv;
    private int aVw;
    private ImageView hDg;
    private View mBottomLine;
    private TextView mSendView;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVt = false;
        this.aVu = true;
        this.aVv = true;
        this.aVw = -1;
        this.aHp = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0175e.tbds144));
        this.aVZ = new LinearLayout(getContext());
        this.aVZ.setOrientation(0);
        this.aVZ.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds90));
        addView(this.aVZ, new LinearLayout.LayoutParams(-1, -2));
        dg(context);
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void dg(Context context) {
        this.hDg = new ImageView(context);
        this.hDg.setEnabled(true);
        this.hDg.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds30), com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds24));
        this.hDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.aVZ.addView(this.hDg, layoutParams);
    }

    private void bQ(Context context) {
        this.aVV = new EditText(context);
        this.aVV.setMinHeight(context.getResources().getDimensionPixelSize(e.C0175e.ds32));
        this.aVV.setMaxLines(4);
        this.aVV.setGravity(16);
        this.aVV.setTextSize(0, getResources().getDimensionPixelSize(e.C0175e.ds32));
        this.aVV.setBackgroundResource(e.d.common_color_10022);
        a(this.aVV, e.f.edittext_cursor);
        this.aVV.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0175e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds24));
        this.aVV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aVV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.aVv) {
                    VideoPlayInputContainer.this.aVv = true;
                    if (VideoPlayInputContainer.this.aVw != -1) {
                        VideoPlayInputContainer.this.aVV.setSelection(VideoPlayInputContainer.this.aVw);
                        VideoPlayInputContainer.this.aVw = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.aVV.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.bKk();
            }
        });
        this.aVV.setHint(context.getString(e.j.reply_something));
        this.aVV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.aVV.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.aVZ.addView(this.aVV, layoutParams);
    }

    private void a(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void bP(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0175e.fontsize32));
        this.mSendView.setText(e.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.h(context, e.C0175e.tbds18));
        layoutParams.gravity = 80;
        this.aVZ.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aVV.getSelectionStart() > 0) {
                        String substring = this.aVV.getText().toString().substring(0, this.aVV.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.djj.matcher(substring);
                        if (matcher.find()) {
                            this.aVV.getText().delete(this.aVV.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aVV.getSelectionStart());
                            return;
                        }
                        this.aVV.getText().delete(this.aVV.getSelectionStart() - 1, this.aVV.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.aVV.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aVV.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.aVV.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.aVV.setSelection(VideoPlayInputContainer.this.aVV.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aVV.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    bKk();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof o)) {
                        o oVar = (o) aVar.data;
                        if (oVar.Fw() == EmotionGroupType.NET_SUG) {
                            a(oVar);
                            return;
                        } else {
                            b(oVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(o oVar) {
        if (oVar != null && !TextUtils.isEmpty(oVar.getName()) && !TextUtils.isEmpty(oVar.getUrl())) {
            String obj = this.aVV.getText().toString();
            if (this.aVu && com.baidu.tieba.face.a.mG(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bs().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), oVar, this.aVV);
            }
        }
    }

    private void b(o oVar) {
        if (!this.aVt || oVar.Fw() == EmotionGroupType.LOCAL) {
            String obj = this.aVV.getText().toString();
            if (this.aVu && com.baidu.tieba.face.a.mG(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bs().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), oVar, this.aVV);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        if (this.aVV != null) {
            this.aVV.setFocusable(true);
            this.aVV.setFocusableInTouchMode(true);
            this.aVV.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aVV);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aHp = i;
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.b(this.aVV, e.d.cp_cont_f, 2, i);
        al.j(this, e.d.cp_bg_line_d);
        if (i == 0) {
            a(this.aVV, e.f.edittext_cursor);
            this.aVV.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_d));
        } else {
            a(this.aVV, e.f.edittext_cursor_1);
            this.aVV.setHintTextColor(al.getColor(i, e.d.cp_cont_d));
        }
        bKk();
        al.c(this.hDg, e.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, this.aHp);
        } else {
            al.c(this.mSendView, e.d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.aVV;
    }
}
