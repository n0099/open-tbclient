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
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools VO;
    private int VP;
    private int bUN;
    private boolean cjW;
    private boolean cjX;
    private boolean cjY;
    private int cjZ;
    private LinearLayout ckC;
    private EditText cky;
    private ImageView fbA;
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
        this.cjW = false;
        this.cjX = true;
        this.cjY = true;
        this.cjZ = -1;
        this.bUN = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.tbds144));
        this.ckC = new LinearLayout(getContext());
        this.ckC.setOrientation(0);
        this.ckC.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.ds90));
        addView(this.ckC, new LinearLayout.LayoutParams(-1, -2));
        eA(context);
        dh(context);
        dg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void eA(Context context) {
        this.fbA = new ImageView(context);
        this.fbA.setEnabled(true);
        this.fbA.setPadding(0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds30), com.baidu.adp.lib.util.l.h(context, d.e.tbds24));
        this.fbA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.ckC.addView(this.fbA, layoutParams);
    }

    private void dh(Context context) {
        this.cky = new EditText(context);
        this.cky.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.cky.setMaxLines(4);
        this.cky.setGravity(16);
        this.cky.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.cky.setBackgroundResource(d.C0277d.common_color_10022);
        e(this.cky, d.f.edittext_cursor);
        this.cky.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.cky.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cky.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.cjY) {
                    VideoPlayInputContainer.this.cjY = true;
                    if (VideoPlayInputContainer.this.cjZ != -1) {
                        VideoPlayInputContainer.this.cky.setSelection(VideoPlayInputContainer.this.cjZ);
                        VideoPlayInputContainer.this.cjZ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.cky.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cmN();
            }
        });
        this.cky.setHint(context.getString(d.j.reply_something));
        this.cky.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.cky.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.ckC.addView(this.cky, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void dg(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.j.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds18));
        layoutParams.gravity = 80;
        this.ckC.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cky.getSelectionStart() > 0) {
                        String substring = this.cky.getText().toString().substring(0, this.cky.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHo.matcher(substring);
                        if (matcher.find()) {
                            this.cky.getText().delete(this.cky.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cky.getSelectionStart());
                            return;
                        }
                        this.cky.getText().delete(this.cky.getSelectionStart() - 1, this.cky.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.cky.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cky.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.cky.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.cky.setSelection(VideoPlayInputContainer.this.cky.getText().length());
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
                        this.cky.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cmN();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.agq() == EmotionGroupType.NET_SUG) {
                            a(pVar);
                            return;
                        } else {
                            b(pVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cky.getText().toString();
            if (this.cjX && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cky);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjW || pVar.agq() == EmotionGroupType.LOCAL) {
            String obj = this.cky.getText().toString();
            if (this.cjX && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cky);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.cky != null) {
            this.cky.setFocusable(true);
            this.cky.setFocusableInTouchMode(true);
            this.cky.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.cky);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.bUN = i;
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        al.c(this.cky, d.C0277d.cp_cont_f, 2, i);
        al.l(this, d.C0277d.cp_bg_line_d);
        if (i == 0) {
            e(this.cky, d.f.edittext_cursor);
            this.cky.setHintTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_d));
        } else {
            e(this.cky, d.f.edittext_cursor_1);
            this.cky.setHintTextColor(al.getColor(i, d.C0277d.cp_cont_d));
        }
        cmN();
        al.c(this.fbA, d.f.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        if (this.mSendView.isEnabled()) {
            al.c(this.mSendView, d.C0277d.cp_link_tip_a, 1, this.bUN);
        } else {
            al.d(this.mSendView, d.C0277d.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.cky;
    }
}
