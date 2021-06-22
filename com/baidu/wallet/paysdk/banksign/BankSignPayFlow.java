package com.baidu.wallet.paysdk.banksign;

import android.content.Context;
/* loaded from: classes5.dex */
public class BankSignPayFlow {

    /* renamed from: a  reason: collision with root package name */
    public Action f25266a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.banksign.a f25267b;

    /* renamed from: com.baidu.wallet.paysdk.banksign.BankSignPayFlow$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25268a;

        static {
            int[] iArr = new int[Action.values().length];
            f25268a = iArr;
            try {
                iArr[Action.ShowGuide.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25268a[Action.Fail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25268a[Action.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25268a[Action.JumpResign.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25268a[Action.Pay.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25268a[Action.BindCard.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25268a[Action.Cancel.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25268a[Action.FirstFail.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25268a[Action.ChangePayType.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Action {
        Null,
        ShowGuide,
        FirstFail,
        Fail,
        Unknown,
        JumpResign,
        Pay,
        Cancel,
        ChangePayType,
        BindCard
    }

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BankSignPayFlow f25269a = new BankSignPayFlow(null);
    }

    public /* synthetic */ BankSignPayFlow(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BankSignPayFlow a() {
        return a.f25269a;
    }

    public BankSignPayFlow() {
        this.f25266a = Action.Null;
        this.f25267b = new b();
    }

    public void a(Action action) {
        if (action == null) {
            action = Action.Null;
        }
        this.f25266a = action;
    }

    public void a(Context context) {
        Action action;
        if (this.f25267b == null || (action = this.f25266a) == null || Action.Null == action) {
            return;
        }
        switch (AnonymousClass1.f25268a[action.ordinal()]) {
            case 1:
                this.f25267b.e(context);
                return;
            case 2:
            case 3:
            case 4:
                this.f25267b.b(context);
                return;
            case 5:
                this.f25267b.a();
                return;
            case 6:
                this.f25267b.c(context);
                this.f25266a = Action.Cancel;
                return;
            case 7:
            case 8:
                this.f25267b.a(context);
                return;
            case 9:
                this.f25267b.d(context);
                this.f25266a = Action.Cancel;
                return;
            default:
                return;
        }
    }
}
