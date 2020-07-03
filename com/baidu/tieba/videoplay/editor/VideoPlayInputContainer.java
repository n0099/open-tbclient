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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes11.dex */
public class VideoPlayInputContainer extends LinearLayout implements m {
    private EditorTools ZX;
    private int ZY;
    private int ahx;
    private TextView bot;
    private EditText evO;
    private LinearLayout evS;
    private boolean evk;
    private boolean evl;
    private boolean evm;
    private int evn;
    private ImageView hDb;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evk = false;
        this.evl = true;
        this.evm = true;
        this.evn = -1;
        this.ahx = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.evS = new LinearLayout(getContext());
        this.evS.setOrientation(0);
        this.evS.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.evS, new LinearLayout.LayoutParams(-1, -2));
        fv(context);
        dS(context);
        dR(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fv(Context context) {
        this.hDb = new ImageView(context);
        this.hDb.setEnabled(true);
        this.hDb.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.hDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.evS.addView(this.hDb, layoutParams);
    }

    private void dS(Context context) {
        this.evO = new EditText(context);
        this.evO.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.evO.setMaxLines(4);
        this.evO.setGravity(16);
        this.evO.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.evO.setBackgroundResource(R.color.common_color_10022);
        e(this.evO, R.drawable.edittext_cursor);
        this.evO.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.evO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.evO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.evm) {
                    VideoPlayInputContainer.this.evm = true;
                    if (VideoPlayInputContainer.this.evn != -1) {
                        VideoPlayInputContainer.this.evO.setSelection(VideoPlayInputContainer.this.evn);
                        VideoPlayInputContainer.this.evn = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.evO.getText().toString()));
                }
                VideoPlayInputContainer.this.bot.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dqh();
            }
        });
        this.evO.setHint(context.getString(R.string.reply_something));
        this.evO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.evO.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.evS.addView(this.evO, layoutParams);
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

    private void dR(Context context) {
        this.bot = new TextView(context);
        this.bot.setGravity(17);
        this.bot.setIncludeFontPadding(false);
        this.bot.setEnabled(false);
        this.bot.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bot.setText(R.string.send_replay);
        this.bot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.evS.addView(this.bot, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.evO.getSelectionStart() > 0) {
                        String substring = this.evO.getText().toString().substring(0, this.evO.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hlN.matcher(substring);
                        if (matcher.find()) {
                            this.evO.getText().delete(this.evO.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.evO.getSelectionStart());
                            return;
                        }
                        this.evO.getText().delete(this.evO.getSelectionStart() - 1, this.evO.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.evO.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.evO.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.evO.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.evO.setSelection(VideoPlayInputContainer.this.evO.getText().length());
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
                        this.evO.setText((CharSequence) null);
                    }
                    this.bot.setEnabled(false);
                    dqh();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof q)) {
                        q qVar = (q) aVar.data;
                        if (qVar.bai() == EmotionGroupType.NET_SUG) {
                            a(qVar);
                            return;
                        } else {
                            b(qVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.evO.getText().toString();
            if (this.evl && com.baidu.tieba.face.a.Er(obj) >= 10 && getContext() != null) {
                e.aVX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.evO);
            }
        }
    }

    private void b(q qVar) {
        if (!this.evk || qVar.bai() == EmotionGroupType.LOCAL) {
            String obj = this.evO.getText().toString();
            if (this.evl && com.baidu.tieba.face.a.Er(obj) >= 10 && getContext() != null) {
                e.aVX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.evO);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.evO != null) {
            this.evO.setFocusable(true);
            this.evO.setFocusableInTouchMode(true);
            this.evO.requestFocus();
            l.showSoftKeyPad(getContext(), this.evO);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.ahx = i;
        an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        an.setViewTextColor(this.evO, R.color.cp_cont_f, 2, i);
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.evO, R.drawable.edittext_cursor);
            this.evO.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            e(this.evO, R.drawable.edittext_cursor_1);
            this.evO.setHintTextColor(an.getColor(i, R.color.cp_cont_d));
        }
        dqh();
        an.setImageResource(this.hDb, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqh() {
        if (this.bot.isEnabled()) {
            an.setViewTextColor(this.bot, R.color.cp_link_tip_a, 1, this.ahx);
        } else {
            an.setViewTextColor(this.bot, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.evO;
    }
}
