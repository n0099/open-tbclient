package com.bytedance.pangle;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.bytedance.pangle.f;
/* loaded from: classes9.dex */
public interface d extends IInterface {
    ComponentName a(Intent intent, String str);

    void a(f fVar);

    boolean a(Intent intent, f fVar, int i, String str);

    boolean b(Intent intent, String str);

    /* loaded from: classes9.dex */
    public static abstract class a extends Binder implements d {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* renamed from: com.bytedance.pangle.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static class C0560a implements d {
            public static d a;
            public IBinder b;

            public C0560a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.d
            public final ComponentName a(Intent intent, String str) {
                ComponentName componentName;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(intent, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        componentName = (ComponentName) ComponentName.CREATOR.createFromParcel(obtain2);
                    } else {
                        componentName = null;
                    }
                    return componentName;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.d
            public final boolean b(Intent intent, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    boolean z = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().b(intent, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.d
            public final void a(f fVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                        a.a().a(fVar);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.d
            public final boolean a(Intent intent, f fVar, int i, String str) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.IServiceManager");
                    boolean z = true;
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (fVar != null) {
                        iBinder = fVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(intent, fVar, i, str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.IServiceManager");
        }

        public static d a() {
            return C0560a.a;
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.IServiceManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0560a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Intent intent = null;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 1598968902) {
                                return super.onTransact(i, parcel, parcel2, i2);
                            }
                            parcel2.writeString("com.bytedance.pangle.IServiceManager");
                            return true;
                        }
                        parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                        a(f.a.a(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    }
                    parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    }
                    boolean a = a(intent, f.a.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a ? 1 : 0);
                    return true;
                }
                parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
                if (parcel.readInt() != 0) {
                    intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                }
                boolean b = b(intent, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b ? 1 : 0);
                return true;
            }
            parcel.enforceInterface("com.bytedance.pangle.IServiceManager");
            if (parcel.readInt() != 0) {
                intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
            }
            ComponentName a2 = a(intent, parcel.readString());
            parcel2.writeNoException();
            if (a2 != null) {
                parcel2.writeInt(1);
                a2.writeToParcel(parcel2, 1);
            } else {
                parcel2.writeInt(0);
            }
            return true;
        }
    }
}
