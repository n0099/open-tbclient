package com.baidu.ugc.editvideo.editvideo.data;

import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.magicmusic.EffectType;
/* loaded from: classes5.dex */
public class EffectData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int baseType;
    public EffectType effectType;
    public int imgBgRes;
    public int imgRes;
    public boolean isSame;
    public MediaAEffectConfig mSpecialEffectData;
    public String name;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EffectData(int i2, int i3, String str, EffectType effectType) {
        this(i2, i3, str, effectType, -1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, effectType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (EffectType) objArr2[3], ((Integer) objArr2[4]).intValue(), (MediaAEffectConfig) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EffectData(int i2, int i3, String str, EffectType effectType, int i4) {
        this(i2, i3, str, effectType, i4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, effectType, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2], (EffectType) objArr2[3], ((Integer) objArr2[4]).intValue(), (MediaAEffectConfig) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public EffectData(int i2, int i3, String str, EffectType effectType, int i4, MediaAEffectConfig mediaAEffectConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str, effectType, Integer.valueOf(i4), mediaAEffectConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.imgRes = i2;
        this.baseType = i3;
        this.name = str;
        this.effectType = effectType;
        this.imgBgRes = i4;
        this.mSpecialEffectData = mediaAEffectConfig;
    }
}
