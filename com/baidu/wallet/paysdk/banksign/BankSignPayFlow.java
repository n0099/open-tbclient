package com.baidu.wallet.paysdk.banksign;

import android.content.Context;
/* loaded from: classes5.dex */
public class BankSignPayFlow {

    /* renamed from: a  reason: collision with root package name */
    public Action f25138a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.wallet.paysdk.banksign.a f25139b;

    /* renamed from: com.baidu.wallet.paysdk.banksign.BankSignPayFlow$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25140a;

        static {
            int[] iArr = new int[Action.values().length];
            f25140a = iArr;
            try {
                iArr[Action.ShowGuide.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25140a[Action.Fail.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25140a[Action.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25140a[Action.JumpResign.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25140a[Action.Pay.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25140a[Action.BindCard.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25140a[Action.Cancel.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25140a[Action.FirstFail.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25140a[Action.ChangePayType.ordinal()] = 9;
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
        public static BankSignPayFlow f25141a = new BankSignPayFlow(null);
    }

    public /* synthetic */ BankSignPayFlow(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BankSignPayFlow a() {
        return a.f25141a;
    }

    public BankSignPayFlow() {
        this.f25138a = Action.Null;
        this.f25139b = new b();
    }

    public void a(Action action) {
        if (action == null) {
            action = Action.Null;
        }
        this.f25138a = action;
    }

    public void a(Context context) {
        Action action;
        if (this.f25139b == null || (action = this.f25138a) == null || Action.Null == action) {
            return;
        }
        switch (AnonymousClass1.f25140a[action.ordinal()]) {
            case 1:
                this.f25139b.e(context);
                return;
            case 2:
            case 3:
            case 4:
                this.f25139b.b(context);
                return;
            case 5:
                this.f25139b.a();
                return;
            case 6:
                this.f25139b.c(context);
                this.f25138a = Action.Cancel;
                return;
            case 7:
            case 8:
                this.f25139b.a(context);
                return;
            case 9:
                this.f25139b.d(context);
                this.f25138a = Action.Cancel;
                return;
            default:
                return;
        }
    }
}
