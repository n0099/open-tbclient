package com.baidu.tieba.voice.tts.bdtts;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tieba.mg;
import com.baidu.tieba.tya;
import com.baidu.tieba.uya;
import com.baidu.tieba.voice.tts.bdtts.BdTtsImpl;
import com.baidu.tieba.vya;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.ITtsError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.SynthesizerResponse;
import com.baidu.tts.client.TtsEntity;
import com.baidu.tts.client.TtsMode;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0007H\u0002J\f\u0010$\u001a\u00020\f*\u00020%H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl;", "Lcom/baidu/tieba/voice/tts/TtsApi;", "Lcom/baidu/tts/client/SpeechSynthesizerListener;", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl$Entry;", "context", "Landroid/content/Context;", "instanceIdToSpeakerId", "addWeakListener", "", "speakerId", "ttsListener", "Lcom/baidu/tieba/voice/tts/TtsListener;", "createSpeaker", "init", "obtainEntry", "onPlayCallback", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "response", "Lcom/baidu/tts/client/SynthesizerResponse;", "onSynthesizeResponse", DownloadStatisticConstants.UBC_TYPE_PAUSE, "pauseAll", "release", "releaseAll", DownloadStatisticConstants.UBC_TYPE_RESUME, "resumeAll", "speak", "text", "stop", "stopAll", "tryContinueSpeakText", "entry", "setOnlineParams", "Lcom/baidu/tts/client/SpeechSynthesizer;", "Companion", "Entry", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BdTtsImpl implements tya, SpeechSynthesizerListener {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public static final Charset e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final ConcurrentHashMap<String, Entry> b;
    public final ConcurrentHashMap<String, String> c;

    /* loaded from: classes8.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-690716559, "Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-690716559, "Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl$b;");
                    return;
                }
            }
            int[] iArr = new int[SynthesizerResponse.SynthesizeType.values().length];
            iArr[SynthesizerResponse.SynthesizeType.PLAY_START.ordinal()] = 1;
            iArr[SynthesizerResponse.SynthesizeType.PLAY_PROGRESS.ordinal()] = 2;
            iArr[SynthesizerResponse.SynthesizeType.PLAY_FINISH.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u000fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÂ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\tHÂ\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0007J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\nJ\u0013\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u001a\u0010\u001f\u001a\u00020\u000f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f0!J\b\u0010\"\u001a\u0004\u0018\u00010\nJ\t\u0010#\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl$Entry;", "Ljava/io/Serializable;", "speaker", "Lcom/baidu/tts/client/SpeechSynthesizer;", "listenerSet", "", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/tieba/voice/tts/TtsListener;", "textQueue", "Lkotlin/collections/ArrayDeque;", "", "(Lcom/baidu/tts/client/SpeechSynthesizer;Ljava/util/Set;Lkotlin/collections/ArrayDeque;)V", "getSpeaker", "()Lcom/baidu/tts/client/SpeechSynthesizer;", "addWeakListener", "", "ttsListener", "clearText", "component1", "component2", "component3", "containsListener", "", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "enqueueText", "text", "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "onEachListener", WebChromeClient.KEY_ARG_CALLBACK, "Lkotlin/Function1;", "pollText", "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Entry implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<WeakReference<uya>> listenerSet;
        public final SpeechSynthesizer speaker;
        public final ArrayDeque<String> textQueue;

        private final Set<WeakReference<uya>> component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.listenerSet : (Set) invokeV.objValue;
        }

        private final ArrayDeque<String> component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.textQueue : (ArrayDeque) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.voice.tts.bdtts.BdTtsImpl$Entry */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Entry copy$default(Entry entry, SpeechSynthesizer speechSynthesizer, Set set, ArrayDeque arrayDeque, int i, Object obj) {
            if ((i & 1) != 0) {
                speechSynthesizer = entry.speaker;
            }
            if ((i & 2) != 0) {
                set = entry.listenerSet;
            }
            if ((i & 4) != 0) {
                arrayDeque = entry.textQueue;
            }
            return entry.copy(speechSynthesizer, set, arrayDeque);
        }

        public final SpeechSynthesizer component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.speaker : (SpeechSynthesizer) invokeV.objValue;
        }

        public final Entry copy(SpeechSynthesizer speaker, Set<WeakReference<uya>> listenerSet, ArrayDeque<String> textQueue) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, speaker, listenerSet, textQueue)) == null) {
                Intrinsics.checkNotNullParameter(speaker, "speaker");
                Intrinsics.checkNotNullParameter(listenerSet, "listenerSet");
                Intrinsics.checkNotNullParameter(textQueue, "textQueue");
                return new Entry(speaker, listenerSet, textQueue);
            }
            return (Entry) invokeLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Entry) {
                    Entry entry = (Entry) obj;
                    return Intrinsics.areEqual(this.speaker, entry.speaker) && Intrinsics.areEqual(this.listenerSet, entry.listenerSet) && Intrinsics.areEqual(this.textQueue, entry.textQueue);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((this.speaker.hashCode() * 31) + this.listenerSet.hashCode()) * 31) + this.textQueue.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "Entry(speaker=" + this.speaker + ", listenerSet=" + this.listenerSet + ", textQueue=" + this.textQueue + ')';
            }
            return (String) invokeV.objValue;
        }

        public Entry(SpeechSynthesizer speaker, Set<WeakReference<uya>> listenerSet, ArrayDeque<String> textQueue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {speaker, listenerSet, textQueue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(speaker, "speaker");
            Intrinsics.checkNotNullParameter(listenerSet, "listenerSet");
            Intrinsics.checkNotNullParameter(textQueue, "textQueue");
            this.speaker = speaker;
            this.listenerSet = listenerSet;
            this.textQueue = textQueue;
        }

        public /* synthetic */ Entry(SpeechSynthesizer speechSynthesizer, Set set, ArrayDeque arrayDeque, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(speechSynthesizer, (i & 2) != 0 ? new LinkedHashSet() : set, (i & 4) != 0 ? new ArrayDeque() : arrayDeque);
        }

        /* renamed from: onEachListener$lambda-0  reason: not valid java name */
        public static final void m143onEachListener$lambda0(Entry this$0, Function1 callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65541, null, this$0, callback) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(callback, "$callback");
                Iterator<WeakReference<uya>> it = this$0.listenerSet.iterator();
                while (it.hasNext()) {
                    uya uyaVar = it.next().get();
                    if (uyaVar == null) {
                        it.remove();
                    } else {
                        callback.invoke(uyaVar);
                    }
                }
            }
        }

        public final void addWeakListener(uya ttsListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ttsListener) == null) {
                Intrinsics.checkNotNullParameter(ttsListener, "ttsListener");
                if (!containsListener(ttsListener)) {
                    this.listenerSet.add(new WeakReference<>(ttsListener));
                }
            }
        }

        public final void enqueueText(String text) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, text) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                ArrayDeque<String> arrayDeque = this.textQueue;
                a aVar = BdTtsImpl.d;
                Charset GBK = BdTtsImpl.e;
                Intrinsics.checkNotNullExpressionValue(GBK, "GBK");
                arrayDeque.addAll(aVar.b(text, 1024, GBK));
            }
        }

        public final void onEachListener(final Function1<? super uya, Unit> callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, callback) == null) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                mg.g(new Runnable() { // from class: com.baidu.tieba.zya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BdTtsImpl.Entry.m143onEachListener$lambda0(BdTtsImpl.Entry.this, callback);
                        }
                    }
                });
            }
        }

        public final void clearText() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.textQueue.clear();
            }
        }

        public final SpeechSynthesizer getSpeaker() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.speaker;
            }
            return (SpeechSynthesizer) invokeV.objValue;
        }

        public final String pollText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.textQueue.removeFirstOrNull();
            }
            return (String) invokeV.objValue;
        }

        public final boolean containsListener(uya ttsListener) {
            InterceptResult invokeL;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ttsListener)) == null) {
                Intrinsics.checkNotNullParameter(ttsListener, "ttsListener");
                Iterator<T> it = this.listenerSet.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((WeakReference) obj).get(), ttsListener)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj != null) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final List<String> b(String str, int i, Charset charset) throws UnsupportedEncodingException {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, str, i, charset)) == null) {
                ArrayList arrayList = new ArrayList();
                byte[] bytes = str.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                int length = bytes.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = length - i2;
                    if (i4 >= i) {
                        i4 = i;
                    }
                    byte[] bArr = new byte[i4];
                    System.arraycopy(bytes, i2, bArr, 0, i4);
                    String str2 = new String(bArr, charset);
                    int length2 = str2.length();
                    String substring = str.substring(i3, i3 + length2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    byte[] bytes2 = substring.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    if (bytes2.length > i) {
                        str2 = str2.substring(0, length2 - 1);
                        Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    i3 += str2.length();
                    arrayList.add(str2);
                    byte[] bytes3 = str2.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                    i2 += bytes3.length;
                }
                return arrayList;
            }
            return (List) invokeLIL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-443176337, "Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-443176337, "Lcom/baidu/tieba/voice/tts/bdtts/BdTtsImpl;");
                return;
            }
        }
        d = new a(null);
        e = Charset.forName("GBK");
    }

    public BdTtsImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
    }

    public synchronized void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(context, "context");
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                this.a = applicationContext;
            }
        }
    }

    public final void q(final SpeechSynthesizer speechSynthesizer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, speechSynthesizer) == null) {
            speechSynthesizer.setParam(SpeechSynthesizer.PARAM_KEY, "com.baidu.tieba");
            speechSynthesizer.setParam(SpeechSynthesizer.PARAM_ONLINE_TIMEOUT, "2000");
            mg.e(new Runnable() { // from class: com.baidu.tieba.yya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BdTtsImpl.r(SpeechSynthesizer.this);
                    }
                }
            });
        }
    }

    public static final void r(SpeechSynthesizer this_setOnlineParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, this_setOnlineParams) == null) {
            Intrinsics.checkNotNullParameter(this_setOnlineParams, "$this_setOnlineParams");
            ITtsError loadOnlineTts = this_setOnlineParams.loadOnlineTts();
            vya.a.a("BdTtsImpl", "setOnlineParams", Integer.valueOf(loadOnlineTts.getDetailCode()), loadOnlineTts.getDetailMessage());
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void e(final String speakerId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, speakerId) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                vya.a.a("BdTtsImpl", "stop", speakerId);
                Entry o = o(speakerId);
                o.getSpeaker().stop();
                o.clearText();
                o.onEachListener(new Function1<uya, Unit>(speakerId, this) { // from class: com.baidu.tieba.voice.tts.bdtts.BdTtsImpl$stop$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String $speakerId;
                    public final /* synthetic */ BdTtsImpl this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {speakerId, this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$speakerId = speakerId;
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(uya uyaVar) {
                        invoke2(uyaVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(uya listener) {
                        Context context;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener) == null) {
                            Intrinsics.checkNotNullParameter(listener, "listener");
                            listener.e(this.$speakerId);
                            context = this.this$0.a;
                            if (context == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("context");
                                context = null;
                            }
                            VideoAudioHelper.muteAudioFocus(new WeakReference(context), false);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void f(String speakerId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, speakerId) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                vya.a.a("BdTtsImpl", DownloadStatisticConstants.UBC_TYPE_PAUSE, speakerId);
                o(speakerId).getSpeaker().pause();
            }
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void g(String speakerId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, speakerId) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                vya.a.a("BdTtsImpl", DownloadStatisticConstants.UBC_TYPE_RESUME, speakerId);
                o(speakerId).getSpeaker().resume();
            }
        }
    }

    public final synchronized Entry o(String str) {
        InterceptResult invokeL;
        Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            synchronized (this) {
                ConcurrentHashMap<String, Entry> concurrentHashMap = this.b;
                Entry entry2 = concurrentHashMap.get(str);
                if (entry2 == null) {
                    entry2 = m(str);
                    ConcurrentHashMap<String, String> concurrentHashMap2 = this.c;
                    String instanceId = entry2.getSpeaker().getInstanceId();
                    Intrinsics.checkNotNullExpressionValue(instanceId, "entry.speaker.instanceId");
                    concurrentHashMap2.put(instanceId, str);
                    Entry putIfAbsent = concurrentHashMap.putIfAbsent(str, entry2);
                    if (putIfAbsent != null) {
                        entry2 = putIfAbsent;
                    }
                }
                Intrinsics.checkNotNullExpressionValue(entry2, "cacheMap.getOrPut(speake…          entry\n        }");
                entry = entry2;
            }
            return entry;
        }
        return (Entry) invokeL.objValue;
    }

    @Override // com.baidu.tts.client.SpeechSynthesizerListener
    public void onSynthesizeResponse(final SynthesizerResponse synthesizerResponse) {
        final String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, synthesizerResponse) != null) || synthesizerResponse == null || (str = this.c.get(synthesizerResponse.getInstanceId())) == null) {
            return;
        }
        Entry o = o(str);
        if (synthesizerResponse.getSynthesizeType() == SynthesizerResponse.SynthesizeType.SYNTHESIZE_FINISH) {
            t(o);
        }
        o.onEachListener(new Function1<uya, Unit>(this, str, synthesizerResponse) { // from class: com.baidu.tieba.voice.tts.bdtts.BdTtsImpl$onSynthesizeResponse$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SynthesizerResponse $response;
            public final /* synthetic */ String $speakerId;
            public final /* synthetic */ BdTtsImpl this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, synthesizerResponse};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.$speakerId = str;
                this.$response = synthesizerResponse;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(uya uyaVar) {
                invoke2(uyaVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(uya it) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.p(it, this.$speakerId, this.$response);
                }
            }
        });
    }

    public final void t(final Entry entry) {
        String pollText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, entry) == null) && (pollText = entry.pollText()) != null) {
            final ITtsError speak = entry.getSpeaker().speak(new TtsEntity(pollText, TtsMode.MIX));
            if (speak.getDetailCode() != 0) {
                entry.onEachListener(new Function1<uya, Unit>(speak, this, entry) { // from class: com.baidu.tieba.voice.tts.bdtts.BdTtsImpl$tryContinueSpeakText$1$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ BdTtsImpl.Entry $entry;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ITtsError $iTtsError;
                    public final /* synthetic */ BdTtsImpl this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {speak, this, entry};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$iTtsError = speak;
                        this.this$0 = this;
                        this.$entry = entry;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(uya uyaVar) {
                        invoke2(uyaVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(uya listener) {
                        ConcurrentHashMap concurrentHashMap;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener) == null) {
                            Intrinsics.checkNotNullParameter(listener, "listener");
                            vya.a.a("BdTtsImpl", "tryContinueSpeakText", Integer.valueOf(this.$iTtsError.getDetailCode()), this.$iTtsError.getDetailMessage());
                            concurrentHashMap = this.this$0.c;
                            Object obj = concurrentHashMap.get(this.$entry.getSpeaker().getInstanceId());
                            Intrinsics.checkNotNull(obj);
                            int detailCode = this.$iTtsError.getDetailCode();
                            String detailMessage = this.$iTtsError.getDetailMessage();
                            Intrinsics.checkNotNullExpressionValue(detailMessage, "iTtsError.detailMessage");
                            listener.a((String) obj, detailCode, detailMessage);
                        }
                    }
                });
            }
        }
    }

    public static final void s(BdTtsImpl this$0, String speakerId, String text) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, this$0, speakerId, text) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(speakerId, "$speakerId");
            Intrinsics.checkNotNullParameter(text, "$text");
            Entry o = this$0.o(speakerId);
            o.clearText();
            o.enqueueText(text);
            o.getSpeaker().stop();
            this$0.t(o);
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                vya.a.a("BdTtsImpl", "releaseAll");
                for (Map.Entry<String, Entry> entry : this.b.entrySet()) {
                    entry.getValue().getSpeaker().release();
                }
            }
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                vya.a.a("BdTtsImpl", "pauseAll");
                for (Map.Entry<String, Entry> entry : this.b.entrySet()) {
                    entry.getValue().getSpeaker().pause();
                }
            }
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                vya.a.a("BdTtsImpl", "resumeAll");
                for (Map.Entry<String, Entry> entry : this.b.entrySet()) {
                    entry.getValue().getSpeaker().resume();
                }
            }
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void d(final String speakerId, final String text) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, speakerId, text) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                Intrinsics.checkNotNullParameter(text, "text");
                vya.a.a("BdTtsImpl", "speak", speakerId, text);
                mg.e(new Runnable() { // from class: com.baidu.tieba.xya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BdTtsImpl.s(BdTtsImpl.this, speakerId, text);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.tya
    public synchronized void h(String speakerId, uya ttsListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, speakerId, ttsListener) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                Intrinsics.checkNotNullParameter(ttsListener, "ttsListener");
                vya.a.a("BdTtsImpl", "addWeakListener", speakerId);
                o(speakerId).addWeakListener(ttsListener);
            }
        }
    }

    public final Entry m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            vya.a.a("BdTtsImpl", "createSpeaker", str);
            Context context = this.a;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            SpeechSynthesizer speechSynthesizer = new SpeechSynthesizer(context);
            speechSynthesizer.setSpeechSynthesizerListener(this);
            speechSynthesizer.setParam(SpeechSynthesizer.PARAM_PRODUCT_ID, "10230");
            speechSynthesizer.setParam(SpeechSynthesizer.PARAM_MIX_MODE, SpeechSynthesizer.MIX_MODE_HIGH_SPEED_NETWORK);
            speechSynthesizer.setParam(SpeechSynthesizer.PARAM_ONLINE_SPEAKER, str);
            q(speechSynthesizer);
            return new Entry(speechSynthesizer, null, null, 6, null);
        }
        return (Entry) invokeL.objValue;
    }

    public final void p(uya uyaVar, String str, SynthesizerResponse synthesizerResponse) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, uyaVar, str, synthesizerResponse) == null) {
            SynthesizerResponse.SynthesizeType synthesizeType = synthesizerResponse.getSynthesizeType();
            if (synthesizeType == null) {
                i = -1;
            } else {
                i = b.$EnumSwitchMapping$0[synthesizeType.ordinal()];
            }
            Context context = null;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        uyaVar.b(str);
                        Context context2 = this.a;
                        if (context2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("context");
                        } else {
                            context = context2;
                        }
                        VideoAudioHelper.muteAudioFocus(new WeakReference(context), false);
                        return;
                    }
                    return;
                }
                uyaVar.c(str, 0);
                return;
            }
            uyaVar.d(str);
            Context context3 = this.a;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context3;
            }
            VideoAudioHelper.muteAudioFocus(new WeakReference(context), true);
        }
    }
}
