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
import com.baidu.tbadk.core.util.am;
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
    private EditorTools TT;
    private int TU;
    private int ceL;
    private EditText cuY;
    private boolean cuw;
    private boolean cux;
    private boolean cuy;
    private int cuz;
    private LinearLayout cvc;
    private ImageView fyZ;
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
        this.cuw = false;
        this.cux = true;
        this.cuy = true;
        this.cuz = -1;
        this.ceL = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.cvc = new LinearLayout(getContext());
        this.cvc.setOrientation(0);
        this.cvc.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.ds90));
        addView(this.cvc, new LinearLayout.LayoutParams(-1, -2));
        et(context);
        cO(context);
        cN(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void et(Context context) {
        this.fyZ = new ImageView(context);
        this.fyZ.setEnabled(true);
        this.fyZ.setPadding(0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds30), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds24));
        this.fyZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.cvc.addView(this.fyZ, layoutParams);
    }

    private void cO(Context context) {
        this.cuY = new EditText(context);
        this.cuY.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cuY.setMaxLines(4);
        this.cuY.setGravity(16);
        this.cuY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cuY.setBackgroundResource(R.color.common_color_10022);
        e(this.cuY, R.drawable.edittext_cursor);
        this.cuY.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.cuY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cuY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.cuy) {
                    VideoPlayInputContainer.this.cuy = true;
                    if (VideoPlayInputContainer.this.cuz != -1) {
                        VideoPlayInputContainer.this.cuY.setSelection(VideoPlayInputContainer.this.cuz);
                        VideoPlayInputContainer.this.cuz = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.cuY.getText().toString()));
                }
                VideoPlayInputContainer.this.mSendView.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.cyQ();
            }
        });
        this.cuY.setHint(context.getString(R.string.reply_something));
        this.cuY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.cuY.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.cvc.addView(this.cuY, layoutParams);
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

    private void cN(Context context) {
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
        this.cvc.addView(this.mSendView, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cuY.getSelectionStart() > 0) {
                        String substring = this.cuY.getText().toString().substring(0, this.cuY.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.feM.matcher(substring);
                        if (matcher.find()) {
                            this.cuY.getText().delete(this.cuY.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cuY.getSelectionStart());
                            return;
                        }
                        this.cuY.getText().delete(this.cuY.getSelectionStart() - 1, this.cuY.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.cuY.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cuY.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.cuY.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.cuY.setSelection(VideoPlayInputContainer.this.cuY.getText().length());
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
                        this.cuY.setText((CharSequence) null);
                    }
                    this.mSendView.setEnabled(false);
                    cyQ();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof p)) {
                        p pVar = (p) aVar.data;
                        if (pVar.amI() == EmotionGroupType.NET_SUG) {
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
            String obj = this.cuY.getText().toString();
            if (this.cux && com.baidu.tieba.face.a.wB(obj) >= 10 && getContext() != null) {
                e.aic().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cuY);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cuw || pVar.amI() == EmotionGroupType.LOCAL) {
            String obj = this.cuY.getText().toString();
            if (this.cux && com.baidu.tieba.face.a.wB(obj) >= 10 && getContext() != null) {
                e.aic().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cuY);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        if (this.cuY != null) {
            this.cuY.setFocusable(true);
            this.cuY.setFocusableInTouchMode(true);
            this.cuY.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.cuY);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ceL = i;
        am.l(this.mBottomLine, R.color.cp_bg_line_c);
        am.d(this.cuY, R.color.cp_cont_f, 2, i);
        am.l(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.cuY, R.drawable.edittext_cursor);
            this.cuY.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.cuY, R.drawable.edittext_cursor_1);
            this.cuY.setHintTextColor(am.getColor(i, R.color.cp_cont_d));
        }
        cyQ();
        am.c(this.fyZ, (int) R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyQ() {
        if (this.mSendView.isEnabled()) {
            am.d(this.mSendView, R.color.cp_link_tip_a, 1, this.ceL);
        } else {
            am.f(this.mSendView, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.cuY;
    }
}
