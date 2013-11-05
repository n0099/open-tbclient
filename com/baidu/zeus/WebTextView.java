package com.baidu.zeus;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.android.internal.widget.EditableInputConnection;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.BDLocation;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class WebTextView extends AutoCompleteTextView {
    private static final boolean DRAW_IMAGE_BKG = false;
    static final int EDIT_ADJUST = 10;
    static final float EDIT_BOX_TOP_HEIGHT = 4.5f;
    static final int EDIT_Circle_SIZE = 20;
    static final float EDIT_INNER_BOX_ADJUST_HEIGHT = 9.0f;
    private static final boolean EDIT_LOG = false;
    static final float EDIT_OUTTER_BOX_ADJUST = 13.0f;
    static final int EDIT_SHADOW_HT = 4;
    static final int EDIT_SHADOW_OFFSET = 2;
    static final String LOGTAG = "webtextview";
    private static final int MAX_INSET = 20;
    private static float density;
    private static float m_circleCenterX;
    private static float m_circleCenterY;
    private static float m_circleRadius;
    private static float m_circleRadiusHalf;
    private static boolean m_inTheCircleBox;
    private static NinePatch np;
    private Drawable mBackground;
    private char[] mCharacter;
    private boolean mDragSent;
    private long mDragStartTime;
    private float mDragStartX;
    private float mDragStartY;
    private boolean mFromFocusChange;
    private boolean mFromSetInputType;
    private boolean mFromWebKit;
    private boolean mGotEnterDown;
    private boolean mGotTouchDown;
    private boolean mHasPerformedLongClick;
    private int mHeightSpec;
    private boolean mInSetTextAndKeepSelection;
    private int mMaxLength;
    private int mNodePointer;
    private int mPreBefore;
    private String mPreChange;
    private CharSequence mPreCharSequence;
    private int mPreCount;
    private int mPreStart;
    private boolean mScrolled;
    private boolean mSingle;
    private WebView mWebView;
    private int mWidthSpec;
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private static Rect m_innerCircleBox = new Rect();
    private static Rect m_innerBox = new Rect();
    private static String myInputTextBmpFile = "zeus_textfield_select";
    static final float EDIT_INNER_TEXT_PADDING = 3.0f;
    private static float m_round_radius = EDIT_INNER_TEXT_PADDING;
    private static float m_stroke_width = 1.2f;
    private static float m_circle_stroke_width = 4.0f;
    private static boolean initNine = false;
    private static float ROUND_RADIUS = EDIT_INNER_TEXT_PADDING;
    private static float STROKE_WIDTH = 1.5f;
    static final float EDIT_INNER_BOX_ADJUST_WIDTH = 2.0f;
    private static float CIRCLE_STROKE_WIDTH = EDIT_INNER_BOX_ADJUST_WIDTH;
    private static int mBkgColor = 0;
    private static int mOutlineColor = 0;
    private static int mTextColor = 0;
    private static int mCircleTopColor = 0;
    private static int mCircleBottomColor = 0;
    private static int mCircleDeleteColor = 0;
    private static int mCircleDeleteShadowColor = 0;
    private static boolean mNightMode = false;
    private static Paint paintBkg = new Paint();
    private static Paint paintCircle = new Paint();
    private static Paint paintChaCha = new Paint();
    private static LinearGradient m_circleGradient = null;
    private static RectF m_tempRectF = new RectF();

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebTextView(Context context, WebView webView) {
        super(context);
        this.mCharacter = new char[1];
        this.mPreStart = 0;
        this.mPreBefore = 0;
        this.mPreCount = 0;
        this.mWebView = webView;
        initTextViewNinePatch(context, myInputTextBmpFile);
        this.mMaxLength = -1;
    }

    public WebTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCharacter = new char[1];
        this.mPreStart = 0;
        this.mPreBefore = 0;
        this.mPreCount = 0;
        initTextViewNinePatch(context, myInputTextBmpFile);
        this.mMaxLength = -1;
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    private void initTextViewNinePatch(Context context, String str) {
        if (!initNine) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), context.getResources().getIdentifier(str, "drawable", context.getApplicationInfo().packageName));
            if (decodeResource != null) {
                np = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
            }
            if (np == null) {
                Log.e("my", "textView drawable not Init");
            } else {
                initNine = true;
            }
            density = getContext().getResources().getDisplayMetrics().density;
        }
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        String str;
        if (keyEvent.isSystem()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z2 = keyEvent.getAction() != 1;
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case 19:
            case 20:
            case 21:
            case 22:
                if (!this.mWebView.nativeCursorMatchesFocus()) {
                    return z2 ? this.mWebView.onKeyDown(keyCode, keyEvent) : this.mWebView.onKeyUp(keyCode, keyEvent);
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (61 == keyCode) {
            if (z2) {
                onEditorAction(5);
                return true;
            }
            return true;
        }
        Editable text = getText();
        int length = text.length();
        if (67 == keyCode && length == 0) {
            sendDomEvent(keyEvent);
            return true;
        } else if (this.mSingle && 66 == keyCode) {
            if (isPopupShowing()) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (!z2) {
                InputMethodManager.getInstance(this.mContext).hideSoftInputFromWindow(getWindowToken(), 0);
                sendDomEvent(new KeyEvent(0, keyCode));
                sendDomEvent(keyEvent);
            }
            return super.dispatchKeyEvent(keyEvent);
        } else if (23 == keyCode) {
            if (isPopupShowing()) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (!this.mWebView.nativeCursorMatchesFocus()) {
                return z2 ? this.mWebView.onKeyDown(keyCode, keyEvent) : this.mWebView.onKeyUp(keyCode, keyEvent);
            }
            if (!z2) {
                this.mWebView.centerKeyPressOnTextField();
            }
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (getLayout() == null) {
                measure(this.mWidthSpec, this.mHeightSpec);
            }
            int selectionStart = Selection.getSelectionStart(text);
            int selectionEnd = Selection.getSelectionEnd(text);
            boolean z3 = this.mMaxLength != -1 && length == this.mMaxLength;
            if (z3 && selectionEnd != selectionStart) {
                str = text.toString();
            } else {
                str = "";
            }
            if (super.dispatchKeyEvent(keyEvent)) {
                if (66 == keyCode) {
                    this.mGotEnterDown = true;
                }
                if (!z3 || z || keyCode == 67 || selectionEnd == selectionStart || str.equals(getText().toString())) {
                    return true;
                }
                Editable text2 = getText();
                this.mWebView.replaceTextfieldText(0, length, text2.toString(), Selection.getSelectionStart(text2), Selection.getSelectionEnd(text2));
                return true;
            } else if (!this.mGotEnterDown || z2) {
                if (z) {
                    this.mWebView.resetTrackballTime();
                    return z2 ? this.mWebView.onKeyDown(keyCode, keyEvent) : this.mWebView.onKeyUp(keyCode, keyEvent);
                }
                return false;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSameTextField(int i) {
        return i == this.mNodePointer;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.mWebView != null) {
            editorInfo.fieldName = this.mWebView.nativeFocusCandidateName() + "\\" + this.mWebView.getUrl();
        }
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        WebView webView = this.mWebView;
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView
    public void onEditorAction(int i) {
        switch (i) {
            case 2:
            case 3:
                InputMethodManager.getInstance(this.mContext).hideSoftInputFromWindow(getWindowToken(), 0);
                sendDomEvent(new KeyEvent(0, 66));
                sendDomEvent(new KeyEvent(1, 66));
                return;
            case 4:
            default:
                return;
            case 5:
                if (this.mWebView.nativeMoveCursorToNextTextInput()) {
                    this.mWebView.setFocusControllerInactive();
                    Log.e(LOGTAG, "onEditorAction call rebuild");
                    this.mWebView.rebuildWebTextView();
                    setDefaultSelection();
                    this.mWebView.invalidate();
                    return;
                }
                return;
            case 6:
                super.onEditorAction(i);
                return;
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        this.mFromFocusChange = true;
        super.onFocusChanged(z, i, rect);
        this.mFromFocusChange = false;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        if (!this.mInSetTextAndKeepSelection) {
            InputMethodManager peekInstance = InputMethodManager.peekInstance();
            if (peekInstance != null && peekInstance.isActive(this)) {
                Editable text = getText();
                peekInstance.updateSelection(this, i, i2, EditableInputConnection.getComposingSpanStart(text), EditableInputConnection.getComposingSpanEnd(text));
            }
            if (!this.mFromWebKit && !this.mFromFocusChange && !this.mFromSetInputType && this.mWebView != null) {
                this.mWebView.setSelection(i, i2);
            }
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        String obj = charSequence.toString();
        if (this.mPreChange == null || this.mPreChange.equals(obj)) {
            return;
        }
        if (this.mMaxLength <= -1 || this.mPreChange.length() <= this.mMaxLength || !this.mPreChange.substring(0, this.mMaxLength).equals(obj)) {
            if (obj.length() > 0) {
                this.mWebView.setNeedTextDeleteBtn(true);
            } else {
                this.mWebView.setNeedTextDeleteBtn(false);
            }
            this.mPreChange = obj;
            this.mPreCharSequence = charSequence;
            this.mPreStart = i;
            this.mPreBefore = i2;
            this.mPreCount = i3;
            this.mWebView.editTextDelaySendToCore();
            if (i3 == 0) {
                if (i2 > 0) {
                    this.mWebView.deleteSelection(i, i + i2);
                    updateCachedTextfield();
                    return;
                }
                return;
            }
            TextUtils.getChars(charSequence, (i + i3) - 1, i + i3, this.mCharacter, 0);
            KeyEvent[] events = KeyCharacterMap.load(0).getEvents(this.mCharacter);
            boolean z = events == null;
            int i4 = z ? 0 : 1;
            if (i3 > 1 || z) {
                this.mWebView.replaceTextfieldText(i, i + i2, charSequence.subSequence(i, (i + i3) - i4).toString(), (i + i3) - i4, (i + i3) - i4);
            } else if (!this.mInSetTextAndKeepSelection) {
                this.mWebView.setSelection(i, i + i2);
            }
            if (!z) {
                int length = events.length;
                for (int i5 = 0; i5 < length; i5++) {
                    if (!KeyEvent.isModifierKey(events[i5].getKeyCode())) {
                        sendDomEvent(events[i5]);
                    }
                }
            }
            updateCachedTextfield();
        }
    }

    public void sendTextChangeToWebCore() {
        if (this.mPreCount == 0) {
            if (this.mPreBefore > 0) {
                this.mWebView.deleteSelection(this.mPreStart, this.mPreStart + this.mPreBefore);
                updateCachedTextfield();
                return;
            }
            return;
        }
        TextUtils.getChars(this.mPreCharSequence, (this.mPreStart + this.mPreCount) - 1, this.mPreStart + this.mPreCount, this.mCharacter, 0);
        KeyCharacterMap.load(0).getEvents(this.mCharacter);
        if (this.mPreCount <= 1) {
        }
        this.mWebView.replaceTextfieldText(this.mPreStart, this.mPreStart + this.mPreBefore, this.mPreCharSequence.subSequence(this.mPreStart, this.mPreStart + this.mPreCount + 0).toString(), this.mPreStart + this.mPreCount + 0, this.mPreStart + this.mPreCount + 0);
        updateCachedTextfield();
    }

    private void setCircleGradientColor(boolean z) {
        if (mNightMode) {
            mCircleTopColor = z ? -10193012 : -11245700;
            mCircleBottomColor = -11245700;
        } else {
            mCircleTopColor = z ? Color.argb((int) Util.MASK_8BIT, 101, (int) DERTags.TAGGED, 157) : Color.argb((int) Util.MASK_8BIT, 85, (int) SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY, 141);
            mCircleBottomColor = Color.argb((int) Util.MASK_8BIT, 132, 158, 187);
        }
        m_circleGradient = null;
        m_circleGradient = new LinearGradient(m_circleCenterX - m_circleRadius, m_circleCenterY - m_circleRadius, m_circleCenterX - m_circleRadius, m_circleCenterY + m_circleRadius, mCircleTopColor, mCircleBottomColor, Shader.TileMode.MIRROR);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWebView != null) {
            WebView webView = this.mWebView;
            switch (motionEvent.getAction()) {
                case 0:
                    if (m_innerCircleBox.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        m_inTheCircleBox = true;
                        setCircleGradientColor(true);
                        break;
                    }
                    break;
                case 1:
                    this.mWebView.setRebuildWebTextView(true);
                    this.mWebView.rebuildWebTextView();
                    this.mWebView.setRebuildWebTextView(false);
                    setCircleGradientColor(false);
                    if (m_innerCircleBox.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                        if (this.mSingle) {
                            setText("");
                        } else {
                            try {
                                String string = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("webclient_del_prompt", "string", this.mContext.getPackageName()));
                                String string2 = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("webclient_del_ok", "string", this.mContext.getPackageName()));
                                String string3 = this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("webclient_del_cancel", "string", this.mContext.getPackageName()));
                                AlertDialog.Builder inverseBackgroundForced = new AlertDialog.Builder(this.mContext).setMessage(string).setCancelable(true).setInverseBackgroundForced(true);
                                inverseBackgroundForced.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.baidu.zeus.WebTextView.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        WebTextView.this.setText("");
                                    }
                                });
                                inverseBackgroundForced.setNegativeButton(string3, (DialogInterface.OnClickListener) null);
                                inverseBackgroundForced.show();
                            } catch (Exception e) {
                                setText("");
                            }
                        }
                    }
                    m_inTheCircleBox = false;
                    this.mWebView.updateCachedTextfield("");
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                super.onTouchEvent(motionEvent);
                this.mDragStartX = motionEvent.getX();
                this.mDragStartY = motionEvent.getY();
                this.mDragStartTime = motionEvent.getEventTime();
                this.mDragSent = false;
                this.mScrolled = false;
                this.mGotTouchDown = true;
                this.mHasPerformedLongClick = false;
                break;
            case 1:
            case 3:
                if (this.mHasPerformedLongClick) {
                    this.mGotTouchDown = false;
                    return false;
                }
                if (!this.mScrolled) {
                    cancelLongPress();
                    if (this.mGotTouchDown && this.mWebView != null) {
                        this.mWebView.touchUpOnTextField(motionEvent);
                    }
                }
                if (this.mWebView != null && this.mDragSent) {
                    this.mWebView.onTouchEvent(motionEvent);
                }
                this.mGotTouchDown = false;
                break;
                break;
            case 2:
                if (this.mHasPerformedLongClick) {
                    this.mGotTouchDown = false;
                    return false;
                }
                int scaledTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
                Editable text = getText();
                int initialScrollX = Touch.getInitialScrollX(this, text);
                int initialScrollY = Touch.getInitialScrollY(this, text);
                super.onTouchEvent(motionEvent);
                int abs = Math.abs(this.mScrollX - initialScrollX);
                int abs2 = Math.abs(this.mScrollY - initialScrollY);
                int i = scaledTouchSlop / 2;
                if (abs > i || abs2 > i) {
                    Layout layout = getLayout();
                    if (this.mWebView != null && layout != null) {
                        float lineRight = layout.getLineRight(0) - getWidth();
                        this.mWebView.scrollFocusedTextInput(lineRight > 0.0f ? this.mScrollX / lineRight : 0.0f, this.mScrollY);
                    }
                    this.mScrolled = true;
                    cancelLongPress();
                    return true;
                } else if (Math.abs(((int) motionEvent.getX()) - this.mDragStartX) >= scaledTouchSlop || Math.abs(((int) motionEvent.getY()) - this.mDragStartY) >= scaledTouchSlop) {
                    if (this.mWebView != null) {
                        if (!this.mDragSent) {
                            this.mWebView.initiateTextFieldDrag(this.mDragStartX, this.mDragStartY, this.mDragStartTime);
                            this.mDragSent = true;
                        }
                        if (this.mWebView.textFieldDrag(motionEvent)) {
                            this.mScrolled = true;
                            cancelLongPress();
                            return true;
                        }
                    }
                    return false;
                } else {
                    return true;
                }
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (isPopupShowing()) {
            return super.onTrackballEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            if (!this.mWebView.nativeCursorMatchesFocus()) {
                return this.mWebView.onTrackballEvent(motionEvent);
            }
            Editable text = getText();
            MovementMethod movementMethod = getMovementMethod();
            return (movementMethod == null || getLayout() == null || !movementMethod.onTrackballEvent(this, text, motionEvent)) ? false : true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.mHasPerformedLongClick = true;
        return super.performLongClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        InputMethodManager.getInstance(this.mContext).hideSoftInputFromWindow(getWindowToken(), 0);
        this.mWebView.removeView(this);
        this.mWebView.requestFocus();
        this.mWebView.setOwnEditOn(false);
        this.mWebView.restoreContentHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bringIntoView() {
        if (getLayout() != null) {
            bringPointIntoView(Selection.getSelectionEnd(getText()));
        }
    }

    private void sendDomEvent(KeyEvent keyEvent) {
        this.mWebView.passToJavaScript(getText().toString(), keyEvent);
    }

    public void setAdapterCustom(AutoCompleteAdapter autoCompleteAdapter) {
        if (autoCompleteAdapter != null) {
            setInputType(getInputType() | 65536);
            autoCompleteAdapter.setTextView(this);
        }
        super.setAdapter(autoCompleteAdapter);
    }

    /* loaded from: classes.dex */
    public class AutoCompleteAdapter extends ArrayAdapter<String> {
        private TextView mTextView;

        public AutoCompleteAdapter(Context context, ArrayList<String> arrayList) {
            super(context, context.getResources().getIdentifier("zeus_search_dropdown_item_line.xml", "layout", context.getPackageName()), arrayList);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            try {
                TextView textView = (TextView) super.getView(i, view, viewGroup);
                if (textView != null && this.mTextView != null) {
                    textView.setTextSize(this.mTextView.getTextSize());
                    return textView;
                }
                return textView;
            } catch (Exception e) {
                TextView textView2 = new TextView(getContext());
                textView2.setTextSize(this.mTextView.getTextSize());
                textView2.setTextAppearance(getContext(), 16973905);
                textView2.setMinimumHeight(((int) textView2.getTextSize()) * 3);
                Log.e(WebTextView.LOGTAG, "getView exception");
                return textView2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTextView(TextView textView) {
            this.mTextView = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDefaultSelection() {
        Editable text = getText();
        int length = this.mSingle ? text.length() : 0;
        if (Selection.getSelectionStart(text) == length && Selection.getSelectionEnd(text) == length) {
            if (this.mWebView != null) {
                this.mWebView.setSelection(length, length);
                return;
            }
            return;
        }
        Selection.setSelection(text, length, length);
    }

    void setBackground() {
        mNightMode = this.mWebView.getSettings() != null && this.mWebView.getSettings().nightModeEnabled();
        if (this.mBackground == null) {
            createBackground();
            setBackgroundDrawable(this.mBackground);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInPassword(boolean z) {
        if (z) {
            setInputType(129);
        }
        WebView webView = this.mWebView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OutlineDrawable extends Drawable {
        private OutlineDrawable() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (WebTextView.mNightMode) {
                int unused = WebTextView.mBkgColor = -13484470;
                int unused2 = WebTextView.mOutlineColor = -11245700;
                int unused3 = WebTextView.mCircleTopColor = -11245700;
                int unused4 = WebTextView.mCircleBottomColor = -11245700;
                int unused5 = WebTextView.mCircleDeleteColor = -13484726;
                int unused6 = WebTextView.mCircleDeleteShadowColor = Color.argb((int) Util.MASK_8BIT, 0, 0, 0);
            } else {
                int unused7 = WebTextView.mBkgColor = -1773833;
                int unused8 = WebTextView.mOutlineColor = -9400399;
                int unused9 = WebTextView.mCircleTopColor = Color.argb((int) Util.MASK_8BIT, 85, (int) SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY, 141);
                int unused10 = WebTextView.mCircleBottomColor = Color.argb((int) Util.MASK_8BIT, 132, 158, 187);
                int unused11 = WebTextView.mCircleDeleteColor = Color.argb((int) Util.MASK_8BIT, 228, 238, 247);
                int unused12 = WebTextView.mCircleDeleteShadowColor = Color.argb((int) Util.MASK_8BIT, 85, (int) SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY, 141);
            }
            WebTextView.m_tempRectF.set(WebTextView.m_innerBox);
            if (WebTextView.paintBkg == null) {
                Paint unused13 = WebTextView.paintBkg = new Paint();
            } else {
                WebTextView.paintBkg.reset();
            }
            WebTextView.paintBkg.setColor(WebTextView.mBkgColor);
            WebTextView.paintBkg.setAntiAlias(true);
            WebTextView.paintBkg.setDither(true);
            canvas.drawRect(WebTextView.m_tempRectF, WebTextView.paintBkg);
            WebTextView.paintBkg.setStyle(Paint.Style.STROKE);
            WebTextView.paintBkg.setStrokeWidth(WebTextView.m_stroke_width);
            WebTextView.paintBkg.setColor(WebTextView.mOutlineColor);
            canvas.drawRect(WebTextView.m_tempRectF, WebTextView.paintBkg);
            if (WebView.ifNeedTextDeleteBtn()) {
                if (WebTextView.paintCircle == null) {
                    Paint unused14 = WebTextView.paintCircle = new Paint();
                } else {
                    WebTextView.paintCircle.reset();
                }
                WebTextView.paintCircle.setAntiAlias(true);
                WebTextView.paintCircle.setDither(true);
                if (WebTextView.m_inTheCircleBox) {
                }
                WebTextView.paintCircle.setShader(WebTextView.m_circleGradient);
                canvas.drawCircle(WebTextView.m_circleCenterX, WebTextView.m_circleCenterY, WebTextView.m_circleRadius, WebTextView.paintCircle);
                if (WebTextView.paintChaCha == null) {
                    Paint unused15 = WebTextView.paintChaCha = new Paint();
                } else {
                    WebTextView.paintChaCha.reset();
                }
                WebTextView.paintChaCha.setAntiAlias(true);
                WebTextView.paintChaCha.setDither(true);
                WebTextView.paintChaCha.setStyle(Paint.Style.STROKE);
                WebTextView.paintChaCha.setStrokeWidth(WebTextView.m_circle_stroke_width);
                if (!WebTextView.mNightMode) {
                    WebTextView.paintChaCha.setColor(WebTextView.mCircleDeleteShadowColor);
                    canvas.drawLine(WebTextView.m_circleCenterX - WebTextView.m_circleRadiusHalf, (WebTextView.m_circleCenterY - WebTextView.m_circleRadiusHalf) + WebTextView.EDIT_INNER_BOX_ADJUST_WIDTH, WebTextView.m_circleRadiusHalf + WebTextView.m_circleCenterX, WebTextView.m_circleCenterY + WebTextView.m_circleRadiusHalf + WebTextView.EDIT_INNER_BOX_ADJUST_WIDTH, WebTextView.paintChaCha);
                    canvas.drawLine(WebTextView.m_circleRadiusHalf + WebTextView.m_circleCenterX, (WebTextView.m_circleCenterY - WebTextView.m_circleRadiusHalf) + WebTextView.EDIT_INNER_BOX_ADJUST_WIDTH, WebTextView.m_circleCenterX - WebTextView.m_circleRadiusHalf, WebTextView.m_circleCenterY + WebTextView.m_circleRadiusHalf + WebTextView.EDIT_INNER_BOX_ADJUST_WIDTH, WebTextView.paintChaCha);
                }
                WebTextView.paintChaCha.setColor(WebTextView.mCircleDeleteColor);
                canvas.drawLine(WebTextView.m_circleCenterX - WebTextView.m_circleRadiusHalf, WebTextView.m_circleCenterY - WebTextView.m_circleRadiusHalf, WebTextView.m_circleRadiusHalf + WebTextView.m_circleCenterX, WebTextView.m_circleRadiusHalf + WebTextView.m_circleCenterY, WebTextView.paintChaCha);
                canvas.drawLine(WebTextView.m_circleRadiusHalf + WebTextView.m_circleCenterX, WebTextView.m_circleCenterY - WebTextView.m_circleRadiusHalf, WebTextView.m_circleCenterX - WebTextView.m_circleRadiusHalf, WebTextView.m_circleRadiusHalf + WebTextView.m_circleCenterY, WebTextView.paintChaCha);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    private void createBackground() {
        if (this.mBackground == null) {
            this.mBackground = new OutlineDrawable();
            setGravity(16);
            TextPaint paint = getPaint();
            paint.setFlags(paint.getFlags() | DERTags.TAGGED | 1);
            setTextColor(-16777216);
        }
    }

    public void deleteBackground() {
        this.mBackground = null;
    }

    @Override // android.widget.TextView
    public void setInputType(int i) {
        this.mFromSetInputType = true;
        super.setInputType(i);
        this.mFromSetInputType = false;
    }

    private void setMaxLength(int i) {
        this.mMaxLength = i;
        if (-1 == i) {
            setFilters(NO_FILTERS);
        } else {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNodePointer(int i) {
        this.mNodePointer = i;
    }

    public static int outterPadding(float f) {
        return (int) (EDIT_OUTTER_BOX_ADJUST * density);
    }

    public static int innerPadding(float f) {
        return (int) (EDIT_INNER_BOX_ADJUST_WIDTH * density * f);
    }

    public static int innerTextPadding(float f) {
        return (int) (EDIT_INNER_TEXT_PADDING * density * f);
    }

    public static int leftPadding(float f) {
        return (int) (EDIT_OUTTER_BOX_ADJUST * density * f);
    }

    public static int topPadding() {
        return (int) (EDIT_OUTTER_BOX_ADJUST * density);
    }

    public static int rightPadding() {
        return (int) (EDIT_OUTTER_BOX_ADJUST * density);
    }

    public static int bottomPadding() {
        return (int) (EDIT_OUTTER_BOX_ADJUST * density);
    }

    public static int innerAdjustWidth() {
        return (int) (EDIT_INNER_BOX_ADJUST_WIDTH * density);
    }

    public static int innerAdjustHeight() {
        return (int) (EDIT_INNER_BOX_ADJUST_HEIGHT * density);
    }

    private int calcCircle(float f, int i, int i2) {
        int height = m_innerBox.height();
        if (height - i > 5) {
            m_circleRadius = (i / EDIT_INNER_BOX_ADJUST_WIDTH) - (EDIT_INNER_BOX_ADJUST_WIDTH * f);
        } else {
            m_circleRadius = (i / EDIT_INNER_BOX_ADJUST_WIDTH) - (4.0f * f);
        }
        m_circleRadiusHalf = m_circleRadius / EDIT_INNER_BOX_ADJUST_WIDTH;
        if (this.mSingle || ((float) height) < m_circleRadius * 4.0f) {
            m_circleCenterY = i2 >> 1;
            m_innerCircleBox.set(0, (int) (m_circleCenterY - m_circleRadius), m_innerBox.right - innerPadding(f), (int) (m_circleCenterY + m_circleRadius));
            m_innerCircleBox.left = m_innerCircleBox.right - m_innerCircleBox.height();
        } else {
            m_innerCircleBox.set(0, m_innerBox.top + innerPadding(f), m_innerBox.right - innerPadding(f), 0);
            m_innerCircleBox.left = m_innerCircleBox.right - ((int) (m_circleRadius * EDIT_INNER_BOX_ADJUST_WIDTH));
            m_innerCircleBox.bottom = m_innerCircleBox.top + ((int) (m_circleRadius * EDIT_INNER_BOX_ADJUST_WIDTH));
            m_circleCenterY = m_innerCircleBox.top + m_circleRadius;
        }
        m_circleCenterX = m_innerCircleBox.left + m_circleRadius;
        int i3 = m_innerCircleBox.top - m_innerBox.top;
        int i4 = i3 <= 20 ? i3 : 20;
        m_innerCircleBox.inset(-i4, -i4);
        return 0;
    }

    private void calcAndSetPadding(float f, int i, int i2, int i3) {
        int innerTextPadding;
        if (this.mSingle || m_innerBox.height() < i2 * 2) {
            innerTextPadding = (i >> 1) - (i2 >> 1);
        } else {
            innerTextPadding = innerTextPadding(f);
        }
        setPadding(outterPadding(f) + innerTextPadding(f), innerTextPadding + outterPadding(f), (m_innerBox.right - m_innerCircleBox.left) + innerTextPadding(f) + outterPadding(f), outterPadding(f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRect(int i, int i2, int i3, int i4, String str) {
        WebView webView = this.mWebView;
        setBackground();
        AbsoluteLayout.LayoutParams layoutParams = null;
        int fontHeight = getFontHeight(getTextSize());
        if (i3 <= fontHeight * 2) {
            i3 += fontHeight;
        }
        int i5 = i4 < fontHeight ? (fontHeight - i4) + i4 : i4;
        float currentScale = this.mWebView.getCurrentScale();
        if (0 == 0) {
            layoutParams = new AbsoluteLayout.LayoutParams((outterPadding(currentScale) * 2) + i3, (outterPadding(currentScale) * 2) + i5, i - outterPadding(currentScale), i2 - outterPadding(currentScale));
            layoutParams.y -= (i5 - i4) / 2;
        }
        m_innerBox.set(outterPadding(currentScale), outterPadding(currentScale), layoutParams.width - outterPadding(currentScale), layoutParams.height - outterPadding(currentScale));
        calcAndSetPadding(currentScale, i5, fontHeight, calcCircle(currentScale, fontHeight, layoutParams.height));
        m_round_radius = this.mWebView.contentToViewDimension((int) ROUND_RADIUS);
        m_stroke_width = STROKE_WIDTH * currentScale;
        m_circle_stroke_width = m_circleRadius / EDIT_BOX_TOP_HEIGHT;
        setCircleGradientColor(false);
        if (this.mWebView.getSettings() != null && this.mWebView.getSettings().nightModeEnabled()) {
            setTextColor(-6968641);
        } else {
            setTextColor(-13019792);
        }
        if (getParent() == null) {
            this.mWebView.addView(this, layoutParams);
        } else {
            setLayoutParams(layoutParams);
        }
        this.mWidthSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        this.mHeightSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
    }

    public int getFontHeight(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelectionFromWebKit(int i, int i2) {
        Editable text;
        int length;
        if (i >= 0 && i2 >= 0 && i <= (length = (text = getText()).length()) && i2 <= length) {
            this.mFromWebKit = true;
            Selection.setSelection(text, i, i2);
            this.mFromWebKit = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTextAndKeepSelection(String str) {
        this.mPreChange = str.toString();
        Editable text = getText();
        int selectionStart = Selection.getSelectionStart(text);
        int selectionEnd = Selection.getSelectionEnd(text);
        this.mInSetTextAndKeepSelection = true;
        text.replace(0, text.length(), str);
        int length = text.length();
        if (selectionStart > length) {
            selectionStart = length;
        }
        if (selectionEnd <= length) {
            length = selectionEnd;
        }
        Selection.setSelection(text, selectionStart, length);
        this.mInSetTextAndKeepSelection = false;
        updateCachedTextfield();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setType(int i) {
        boolean z;
        String nativeFocusCandidateName;
        boolean z2 = false;
        int i2 = 1;
        if (this.mWebView != null) {
            int i3 = -1;
            int i4 = this.mWebView.nativeFocusCandidateHasNextTextfield() ? BDLocation.TypeNetWorkLocation : 1;
            WebView webView = this.mWebView;
            switch (i) {
                case 0:
                    z = false;
                    z2 = true;
                    i2 = 2;
                    break;
                case 1:
                    i4 = 180225;
                    z = false;
                    break;
                case 2:
                    z = true;
                    z2 = true;
                    i2 = 2;
                    break;
                case 3:
                    z = false;
                    z2 = true;
                    i2 = 3;
                    break;
                case 4:
                    z = false;
                    z2 = true;
                    i2 = 2;
                    break;
                case 5:
                    i4 |= 2;
                    z = false;
                    z2 = true;
                    i2 = 5;
                    break;
                case 6:
                    i4 |= 3;
                    z = false;
                    z2 = true;
                    i2 = 5;
                    break;
                case 7:
                    z = false;
                    z2 = true;
                    i2 = 2;
                    break;
                default:
                    z = false;
                    z2 = true;
                    i2 = 2;
                    break;
            }
            setHint((CharSequence) null);
            if (z2) {
                this.mWebView.requestLabel(this.mWebView.nativeFocusCandidateFramePointer(), this.mNodePointer);
                i3 = this.mWebView.nativeFocusCandidateMaxLength();
                if (i != 2 && (nativeFocusCandidateName = this.mWebView.nativeFocusCandidateName()) != null && nativeFocusCandidateName.length() > 0) {
                    this.mWebView.requestFormData(nativeFocusCandidateName, this.mNodePointer);
                }
            }
            this.mSingle = z2;
            setMaxLength(i3);
            setHorizontallyScrolling(z2);
            setInputType(i4);
            setImeOptions(i2);
            setInPassword(z);
            setAdapterCustom(null);
        }
    }

    void updateCachedTextfield() {
        this.mWebView.updateCachedTextfield(getText().toString());
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(Rect rect) {
        if (this.mWebView.inAnimateZoom()) {
            return false;
        }
        return super.requestRectangleOnScreen(rect);
    }
}
