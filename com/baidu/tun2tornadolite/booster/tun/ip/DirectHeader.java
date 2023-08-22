package com.baidu.tun2tornadolite.booster.tun.ip;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.msp.push.mode.MessageStat;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J8\u0010\r\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00130\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0016J\u008b\u0001\u0010\u0017\u001a\u0017\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00130\u000e\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0014\u001a\u00020\u00052!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00180\u001a26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u001e0\u001dH\u0000¢\u0006\u0002\b\u001fJ*\u0010 \u001a\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00130\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b!J*\u0010\"\u001a\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00130\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b#J*\u0010$\u001a\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u00130\u000e2\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0002\b%R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006("}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;", "", "buffer", "", "offset", "", "([BI)V", "getBuffer", "()[B", "setBuffer", "([B)V", "getOffset", "()I", "byteArray", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Field;", "", "", "Lkotlin/ParameterName;", "name", "value", CriusAttrConstants.POSITION, "length", "byteArray$tun2tornadolite_release", "field", ExifInterface.GPS_DIRECTION_TRUE, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lkotlin/Function1;", "index", "set", "Lkotlin/Function2;", "", "field$tun2tornadolite_release", "int16", "int16$tun2tornadolite_release", "int4Left", "int4Left$tun2tornadolite_release", "int8", "int8$tun2tornadolite_release", "Companion", "Field", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public abstract class DirectHeader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTE_LENGTH = 8;
    public static final Companion Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] buffer;
    public final int offset;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1565742813, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1565742813, "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Companion;", "", "()V", "BYTE_LENGTH", "", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\"\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0086\u0002¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0018\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0019R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader$Field;", ExifInterface.GPS_DIRECTION_TRUE, "", CriusAttrConstants.POSITION, "", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "Lkotlin/Function1;", "set", "Lkotlin/Function2;", "", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getGet", "()Lkotlin/jvm/functions/Function1;", "getPosition", "()I", "getSet", "()Lkotlin/jvm/functions/Function2;", "getValue", "thiz", "Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;", MessageStat.PROPERTY, "Lkotlin/reflect/KProperty;", "(Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "value", "(Lcom/baidu/tun2tornadolite/booster/tun/ip/DirectHeader;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "tun2tornadolite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Field<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function1<Integer, T> get;
        public final int position;
        public final Function2<Integer, T, Unit> set;

        public Field(int i, Function1<? super Integer, ? extends T> get, Function2<? super Integer, ? super T, Unit> set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), get, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(get, "get");
            Intrinsics.checkNotNullParameter(set, "set");
            this.position = i;
            this.get = get;
            this.set = set;
        }

        public final Function1<Integer, T> getGet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.get;
            }
            return (Function1) invokeV.objValue;
        }

        public final int getPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.position;
            }
            return invokeV.intValue;
        }

        public final Function2<Integer, T, Unit> getSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.set;
            }
            return (Function2) invokeV.objValue;
        }

        public final T getValue(DirectHeader thiz, KProperty<?> property) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, thiz, property)) == null) {
                Intrinsics.checkNotNullParameter(thiz, "thiz");
                Intrinsics.checkNotNullParameter(property, "property");
                return this.get.invoke(Integer.valueOf(this.position));
            }
            return (T) invokeLL.objValue;
        }

        public final void setValue(DirectHeader thiz, KProperty<?> property, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, thiz, property, t) == null) {
                Intrinsics.checkNotNullParameter(thiz, "thiz");
                Intrinsics.checkNotNullParameter(property, "property");
                this.set.invoke(Integer.valueOf(this.position), t);
            }
        }
    }

    public DirectHeader(byte[] buffer, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        this.offset = i;
    }

    public final Field<List<Byte>> byteArray$tun2tornadolite_release(int i, final int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            return field$tun2tornadolite_release(i, new Function1<Integer, List<? extends Byte>>(this, i2) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$byteArray$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $length;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$length = i2;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ List<? extends Byte> invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final List<Byte> invoke(int i3) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3)) == null) {
                        return ArraysKt___ArraysKt.slice(this.this$0.getBuffer(), new IntRange(i3, this.$length - 1));
                    }
                    return (List) invokeI.objValue;
                }
            }, new Function2<Integer, List<? extends Byte>, Unit>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$byteArray$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Byte> list) {
                    invoke(num.intValue(), (List<Byte>) list);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, List<Byte> value) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, value) == null) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        int size = value.size() - 1;
                        if (size >= 0) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4 + 1;
                                this.this$0.getBuffer()[i3 + i4] = value.get(i4).byteValue();
                                if (i5 <= size) {
                                    i4 = i5;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            });
        }
        return (Field) invokeII.objValue;
    }

    public final <T> Field<T> field$tun2tornadolite_release(int i, Function1<? super Integer, ? extends T> get, Function2<? super Integer, ? super T, Unit> set) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, get, set)) == null) {
            Intrinsics.checkNotNullParameter(get, "get");
            Intrinsics.checkNotNullParameter(set, "set");
            return new Field<>(this.offset + i, get, set);
        }
        return (Field) invokeILL.objValue;
    }

    public final byte[] getBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.buffer;
        }
        return (byte[]) invokeV.objValue;
    }

    public final int getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.offset;
        }
        return invokeV.intValue;
    }

    public final Field<Integer> int16$tun2tornadolite_release(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return field$tun2tornadolite_release(i, new Function1<Integer, Integer>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$int16$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                public final Integer invoke(int i2) {
                    InterceptResult invokeI2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI2 = interceptable2.invokeI(1048576, this, i2)) == null) {
                        return Integer.valueOf(UShort.m1127constructorimpl((short) ((UByte.m867constructorimpl(this.this$0.getBuffer()[i2 + 1]) & 255 & 255) | (((UByte.m867constructorimpl(this.this$0.getBuffer()[i2]) & 255) & 255) << 8))) & UShort.MAX_VALUE);
                    }
                    return (Integer) invokeI2.objValue;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }, new Function2<Integer, Integer, Unit>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$int16$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        this.this$0.getBuffer()[i2] = (byte) ((i3 >> 8) & 255);
                        this.this$0.getBuffer()[i2 + 1] = (byte) (i3 & 255);
                    }
                }
            });
        }
        return (Field) invokeI.objValue;
    }

    public final Field<Integer> int4Left$tun2tornadolite_release(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return field$tun2tornadolite_release(i, new Function1<Integer, Integer>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$int4Left$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                public final Integer invoke(int i2) {
                    InterceptResult invokeI2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI2 = interceptable2.invokeI(1048576, this, i2)) == null) {
                        return Integer.valueOf((UByte.m867constructorimpl(this.this$0.getBuffer()[i2]) & 255) >>> 4);
                    }
                    return (Integer) invokeI2.objValue;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }, new Function2<Integer, Integer, Unit>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$int4Left$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        this.this$0.getBuffer()[i2] = (byte) (((i3 >>> 4) << 4) | (((UByte.m867constructorimpl(this.this$0.getBuffer()[i2]) & 255) << 4) >>> 4));
                    }
                }
            });
        }
        return (Field) invokeI.objValue;
    }

    public final Field<Integer> int8$tun2tornadolite_release(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return field$tun2tornadolite_release(i, new Function1<Integer, Integer>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$int8$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                public final Integer invoke(int i2) {
                    InterceptResult invokeI2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI2 = interceptable2.invokeI(1048576, this, i2)) == null) {
                        return Integer.valueOf(UByte.m867constructorimpl(this.this$0.getBuffer()[i2]) & 255);
                    }
                    return (Integer) invokeI2.objValue;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }, new Function2<Integer, Integer, Unit>(this) { // from class: com.baidu.tun2tornadolite.booster.tun.ip.DirectHeader$int8$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DirectHeader this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke(num.intValue(), num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        this.this$0.getBuffer()[i2] = (byte) i3;
                    }
                }
            });
        }
        return (Field) invokeI.objValue;
    }

    public final void setBuffer(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            Intrinsics.checkNotNullParameter(bArr, "<set-?>");
            this.buffer = bArr;
        }
    }
}
