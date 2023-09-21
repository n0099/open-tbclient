package com.baidu.tieba;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes8.dex */
public abstract class uk1 implements IBinder, IBinder.DeathRecipient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile IBinder a;
    public HashSet<IBinder.DeathRecipient> b;
    public Object c;

    public static void b(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, exc) == null) {
        }
    }

    public abstract IBinder c() throws RemoteException;

    public uk1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashSet<>();
        this.c = new Object();
    }

    public final IBinder a() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.c) {
                IBinder iBinder = this.a;
                if (iBinder != null) {
                    return iBinder;
                }
                IBinder c = c();
                this.a = c;
                if (c != null) {
                    c.linkToDeath(this, 0);
                    return c;
                }
                throw new RemoteException();
            }
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return a().getInterfaceDescriptor();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return a().isBinderAlive();
            } catch (RemoteException e) {
                b("MultiProcess", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return a().pingBinder();
            } catch (RemoteException e) {
                b("MultiProcess", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.c) {
                IBinder iBinder = this.a;
                if (iBinder != null) {
                    iBinder.unlinkToDeath(this, 0);
                    this.a = null;
                }
                ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
                synchronized (this.b) {
                    arrayList.addAll(this.b);
                }
                for (IBinder.DeathRecipient deathRecipient : arrayList) {
                    deathRecipient.binderDied();
                }
            }
        }
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, fileDescriptor, strArr) == null) {
            a().dump(fileDescriptor, strArr);
        }
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fileDescriptor, strArr) == null) {
            a().dumpAsync(fileDescriptor, strArr);
        }
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, deathRecipient, i) == null) {
            synchronized (this.b) {
                this.b.add(deathRecipient);
            }
        }
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, deathRecipient, i)) == null) {
            synchronized (this.b) {
                this.b.remove(deathRecipient);
            }
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                return a().queryLocalInterface(str);
            } catch (RemoteException e) {
                b("MultiProcess", e);
                return null;
            }
        }
        return (IInterface) invokeL.objValue;
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
            return a().transact(i, parcel, parcel2, i2);
        }
        return invokeCommon.booleanValue;
    }
}
