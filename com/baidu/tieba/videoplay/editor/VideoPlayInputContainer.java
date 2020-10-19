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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes24.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools abj;
    private int abk;
    private int ajp;
    private TextView bEw;
    private boolean faF;
    private boolean faG;
    private boolean faH;
    private int faI;
    private EditText fbI;
    private LinearLayout fbM;
    private ImageView isw;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.faF = false;
        this.faG = true;
        this.faH = true;
        this.faI = -1;
        this.ajp = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fbM = new LinearLayout(getContext());
        this.fbM.setOrientation(0);
        this.fbM.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fbM, new LinearLayout.LayoutParams(-1, -2));
        fY(context);
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fY(Context context) {
        this.isw = new ImageView(context);
        this.isw.setEnabled(true);
        this.isw.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.isw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fbM.addView(this.isw, layoutParams);
    }

    private void ep(Context context) {
        this.fbI = new EditText(context);
        this.fbI.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fbI.setMaxLines(4);
        this.fbI.setGravity(16);
        this.fbI.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fbI.setBackgroundResource(R.color.common_color_10022);
        g(this.fbI, R.drawable.edittext_cursor);
        this.fbI.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fbI.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fbI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.faH) {
                    VideoPlayInputContainer.this.faH = true;
                    if (VideoPlayInputContainer.this.faI != -1) {
                        VideoPlayInputContainer.this.fbI.setSelection(VideoPlayInputContainer.this.faI);
                        VideoPlayInputContainer.this.faI = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fbI.getText().toString()));
                }
                VideoPlayInputContainer.this.bEw.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dMF();
            }
        });
        this.fbI.setHint(context.getString(R.string.reply_something));
        this.fbI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fbI.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fbM.addView(this.fbI, layoutParams);
    }

    private void g(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void eo(Context context) {
        this.bEw = new TextView(context);
        this.bEw.setGravity(17);
        this.bEw.setIncludeFontPadding(false);
        this.bEw.setEnabled(false);
        this.bEw.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bEw.setText(R.string.send_replay);
        this.bEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fbM.addView(this.bEw, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fbI.getSelectionStart() > 0) {
                        String substring = this.fbI.getText().toString().substring(0, this.fbI.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iaR.matcher(substring);
                        if (matcher.find()) {
                            this.fbI.getText().delete(this.fbI.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fbI.getSelectionStart());
                            return;
                        }
                        this.fbI.getText().delete(this.fbI.getSelectionStart() - 1, this.fbI.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fbI.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fbI.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fbI.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fbI.setSelection(VideoPlayInputContainer.this.fbI.getText().length());
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
                        this.fbI.setText((CharSequence) null);
                    }
                    this.bEw.setEnabled(false);
                    dMF();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bqt() == EmotionGroupType.NET_SUG) {
                            a(uVar);
                            return;
                        } else {
                            b(uVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fbI.getText().toString();
            if (this.faG && com.baidu.tieba.face.a.IO(obj) >= 10 && getContext() != null) {
                e.blW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fbI);
            }
        }
    }

    private void b(u uVar) {
        if (!this.faF || uVar.bqt() == EmotionGroupType.LOCAL) {
            String obj = this.fbI.getText().toString();
            if (this.faG && com.baidu.tieba.face.a.IO(obj) >= 10 && getContext() != null) {
                e.blW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fbI);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abk;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fbI != null) {
            this.fbI.setFocusable(true);
            this.fbI.setFocusableInTouchMode(true);
            this.fbI.requestFocus();
            l.showSoftKeyPad(getContext(), this.fbI);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ajp = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fbI, R.color.cp_cont_f, 2, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.fbI, R.drawable.edittext_cursor);
            this.fbI.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            g(this.fbI, R.drawable.edittext_cursor_1);
            this.fbI.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        dMF();
        ap.setImageResource(this.isw, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMF() {
        if (this.bEw.isEnabled()) {
            ap.setViewTextColor(this.bEw, R.color.cp_link_tip_a, 1, this.ajp);
        } else {
            ap.setViewTextColor(this.bEw, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.fbI;
    }
}
