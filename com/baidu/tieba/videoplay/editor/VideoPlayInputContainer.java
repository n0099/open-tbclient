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
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements l {
    private EditorTools TA;
    private int TB;
    private int ccJ;
    private EditText csH;
    private LinearLayout csL;
    private boolean csf;
    private boolean csg;
    private boolean csh;
    private int csi;
    private ImageView frQ;
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
        this.csf = false;
        this.csg = true;
        this.csh = true;
        this.csi = -1;
        this.ccJ = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.csL = new LinearLayout(getContext());
        this.csL.setOrientation(0);
        this.csL.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.ds90));
        addView(this.csL, new LinearLayout.LayoutParams(-1, -2));
        eq(context);
        cN(context);
        cM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void eq(Context context) {
        this.frQ = new ImageView(context);
        this.frQ.setEnabled(true);
        this.frQ.setPadding(0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds30), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds24));
        this.frQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.csL.addView(this.frQ, layoutParams);
    }

    private void cN(Context context) {
        this.csH = new EditText(context);
        this.csH.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csH.setMaxLines(4);
        this.csH.setGravity(16);
        this.csH.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csH.setBackgroundResource(R.color.common_color_10022);
        e(this.csH, R.drawable.edittext_cursor);
        this.csH.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.csH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.csH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.csh) {
                    VideoPlayInputContainer.this.csh = true;
                    if (VideoPlayInputContainer.this.csi != -1) {
                        VideoPlayInputContainer.this.csH.setSelection(VideoPlayInputContainer.this.csi);
                        VideoPlayInputContainer.this.csi = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.csH.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cuR();
            }
        });
        this.csH.setHint(context.getString(R.string.reply_something));
        this.csH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.csH.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.csL.addView(this.csH, layoutParams);
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

    private void cM(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.mSendView.setText(R.string.replay);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.csL.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.csH.getSelectionStart() > 0) {
                        String substring = this.csH.getText().toString().substring(0, this.csH.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eXy.matcher(substring);
                        if (matcher.find()) {
                            this.csH.getText().delete(this.csH.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.csH.getSelectionStart());
                            return;
                        }
                        this.csH.getText().delete(this.csH.getSelectionStart() - 1, this.csH.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.csH.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.csH.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.csH.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.csH.setSelection(VideoPlayInputContainer.this.csH.getText().length());
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
                        this.csH.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cuR();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.alp() == EmotionGroupType.NET_SUG) {
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
            String obj = this.csH.getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.csH);
            }
        }
    }

    private void b(p pVar) {
        if (!this.csf || pVar.alp() == EmotionGroupType.LOCAL) {
            String obj = this.csH.getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.csH);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.csH != null) {
            this.csH.setFocusable(true);
            this.csH.setFocusableInTouchMode(true);
            this.csH.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.csH);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ccJ = i;
        al.l(this.mBottomLine, R.color.cp_bg_line_c);
        al.c(this.csH, R.color.cp_cont_f, 2, i);
        al.l(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.csH, R.drawable.edittext_cursor);
            this.csH.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.csH, R.drawable.edittext_cursor_1);
            this.csH.setHintTextColor(al.getColor(i, R.color.cp_cont_d));
        }
        cuR();
        al.c(this.frQ, (int) R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuR() {
        if (this.mSendView.isEnabled()) {
            al.c(this.mSendView, R.color.cp_link_tip_a, 1, this.ccJ);
        } else {
            al.f(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.csH;
    }
}
